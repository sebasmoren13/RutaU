package com.rutau.rutau.Service.ServiceImpl;

import com.rutau.rutau.Entity.Paradero;
import com.rutau.rutau.Entity.Recorrido;
import com.rutau.rutau.Entity.Reserva;
import com.rutau.rutau.Entity.Usuario;
import com.rutau.rutau.Exception.ReglaNegocioException;
import com.rutau.rutau.Exception.ResourceNotFoundException;
import com.rutau.rutau.Repository.ParaderoRepository;
import com.rutau.rutau.Repository.ReservaRepository;
import com.rutau.rutau.Repository.UsuarioRepository;
import com.rutau.rutau.Service.RecorridoService;
import com.rutau.rutau.Service.ReservaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;
    private final RecorridoService recorridoService;
    private final UsuarioRepository usuarioRepository;
    private final ParaderoRepository paraderoRepository;

    public ReservaServiceImpl(ReservaRepository reservaRepository,
                              RecorridoService recorridoService,
                              UsuarioRepository usuarioRepository,
                              ParaderoRepository paraderoRepository) {
        this.reservaRepository = reservaRepository;
        this.recorridoService = recorridoService;
        this.usuarioRepository = usuarioRepository;
        this.paraderoRepository = paraderoRepository;
    }

    @Override
    @Transactional
    public Reserva crearReserva(Long usuarioId, Long recorridoId, Long paraderoId) {
        if (verificarConflictosHorario(usuarioId, recorridoId)) {
            throw new ReglaNegocioException("El usuario ya tiene una reserva para este recorrido");
        }

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        Paradero paradero = paraderoRepository.findById(paraderoId)
                .orElseThrow(() -> new ResourceNotFoundException("Paradero no encontrado"));

        Recorrido recorrido = recorridoService.obtenerParaActualizarCupo(recorridoId);
        if (recorrido.getCuposDisponibles() <= 0) {
            throw new ReglaNegocioException("No hay cupos disponibles para este recorrido");
        }
        recorrido.setCuposDisponibles(recorrido.getCuposDisponibles() - 1);
        recorridoService.programarRecorrido(recorrido);

        Reserva reserva = new Reserva();
        reserva.setUsuario(usuario);
        reserva.setRecorrido(recorrido);
        reserva.setParadero(paradero);
        reserva.setCodigoQr(UUID.randomUUID().toString());
        reserva.setFechaCreacion(LocalDateTime.now());
        reserva.setEstado("Pendiente");

        return reservaRepository.save(reserva);
    }

    @Override
    public Optional<Reserva> buscarPorId(Long id) {
        return reservaRepository.findById(id);
    }

    @Override
    public Optional<Reserva> buscarPorCodigoQr(String codigoQr) {
        return reservaRepository.findByCodigoQr(codigoQr);
    }

    @Override
    public List<Reserva> listarPorUsuario(Long usuarioId) {
        return reservaRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Reserva> listarPorUsuarioYEstado(Long usuarioId, String estado) {
        return reservaRepository.findByUsuarioIdAndEstado(usuarioId, estado);
    }

    @Override
    @Transactional
    public void cancelarReserva(Long reservaId) {
        Reserva reserva = reservaRepository.findById(reservaId)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada"));

        if (!"Pendiente".equals(reserva.getEstado())) {
            throw new ReglaNegocioException("Solo se puede cancelar una reserva pendiente");
        }

        reserva.setEstado("Cancelada");
        reservaRepository.save(reserva);

        Recorrido recorrido = recorridoService.obtenerParaActualizarCupo(reserva.getRecorrido().getId());
        recorrido.setCuposDisponibles(recorrido.getCuposDisponibles() + 1);
        recorridoService.programarRecorrido(recorrido);
    }

    @Override
    public boolean verificarConflictosHorario(Long usuarioId, Long recorridoId) {
        return !reservaRepository.findConflictos(usuarioId, recorridoId).isEmpty();
    }
}