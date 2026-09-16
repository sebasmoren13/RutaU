package com.rutau.rutau.Service.ServiceImpl;

import com.rutau.rutau.Entity.Abordaje;
import com.rutau.rutau.Entity.Reserva;
import com.rutau.rutau.Entity.Usuario;
import com.rutau.rutau.Exception.ReglaNegocioException;
import com.rutau.rutau.Exception.ResourceNotFoundException;
import com.rutau.rutau.Repository.AbordajeRepository;
import com.rutau.rutau.Repository.ReservaRepository;
import com.rutau.rutau.Repository.UsuarioRepository;
import com.rutau.rutau.Service.AbordajeService;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class AbordajeServiceImpl implements AbordajeService {

    private final AbordajeRepository abordajeRepository;
    private final ReservaRepository reservaRepository;
    private final UsuarioRepository usuarioRepository;

    public AbordajeServiceImpl(AbordajeRepository abordajeRepository,
                               ReservaRepository reservaRepository,
                               UsuarioRepository usuarioRepository) {
        this.abordajeRepository = abordajeRepository;
        this.reservaRepository = reservaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Abordaje registrarAbordaje(String codigoQr, Long conductorId) {
        Reserva reserva = reservaRepository.findByCodigoQr(codigoQr)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada para el código QR"));

        if (!"Pendiente".equals(reserva.getEstado())) {
            throw new ReglaNegocioException("La reserva no está en estado válido para abordar");
        }
        if (abordajeRepository.existsByReservaId(reserva.getId())) {
            throw new ReglaNegocioException("Esta reserva ya fue abordada");
        }

        Usuario conductor = usuarioRepository.findById(conductorId)
                .orElseThrow(() -> new ResourceNotFoundException("Conductor no encontrado"));

        Abordaje abordaje = new Abordaje();
        abordaje.setReserva(reserva);
        abordaje.setConductor(conductor);
        abordaje.setHoraLectura(LocalTime.now());
        abordaje.setEstadoValidacion("Exitoso");

        reserva.setEstado("Abordó");
        reservaRepository.save(reserva);

        return abordajeRepository.save(abordaje);
    }

    @Override
    public Optional<Abordaje> buscarPorReserva(Long reservaId) {
        return abordajeRepository.findByReservaId(reservaId);
    }

    @Override
    public boolean yaFueAbordado(Long reservaId) {
        return abordajeRepository.existsByReservaId(reservaId);
    }
}