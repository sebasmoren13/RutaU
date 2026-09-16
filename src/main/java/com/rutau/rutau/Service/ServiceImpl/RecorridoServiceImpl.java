package com.rutau.rutau.Service.ServiceImpl;

import com.rutau.rutau.Entity.Recorrido;
import com.rutau.rutau.Exception.ResourceNotFoundException;
import com.rutau.rutau.Repository.RecorridoRepository;
import com.rutau.rutau.Service.RecorridoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RecorridoServiceImpl implements RecorridoService {

    private final RecorridoRepository recorridoRepository;

    public RecorridoServiceImpl(RecorridoRepository recorridoRepository) {
        this.recorridoRepository = recorridoRepository;
    }

    @Override
    public Recorrido programarRecorrido(Recorrido recorrido) {
        recorrido.setEstado("Programado");
        return recorridoRepository.save(recorrido);
    }

    @Override
    public Optional<Recorrido> buscarPorId(Long id) {
        return recorridoRepository.findById(id);
    }

    @Override
    public List<Recorrido> listarPorRutaYFecha(Long idRuta, LocalDate fecha) {
        return recorridoRepository.findByIdRutaAndFecha(idRuta, fecha);
    }

    @Override
    public List<Recorrido> listarDisponibles(Long idRuta, LocalDate fecha) {
        return recorridoRepository.findDisponiblesPorRutaYFecha(idRuta, fecha);
    }

    @Override
    @Transactional
    public Recorrido obtenerParaActualizarCupo(Long idRecorrido) {
        return recorridoRepository.findByIdForUpdate(idRecorrido)
                .orElseThrow(() -> new ResourceNotFoundException("Recorrido no encontrado"));
    }

    @Override
    public void cambiarEstado(Long idRecorrido, String nuevoEstado) {
        Recorrido recorrido = recorridoRepository.findById(idRecorrido)
                .orElseThrow(() -> new ResourceNotFoundException("Recorrido no encontrado"));
        recorrido.setEstado(nuevoEstado);
        recorridoRepository.save(recorrido);
    }
}