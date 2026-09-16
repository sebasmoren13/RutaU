package com.rutau.rutau.Service.ServiceImpl;

import com.rutau.rutau.Entity.Ruta;
import com.rutau.rutau.Exception.ResourceNotFoundException;
import com.rutau.rutau.Repository.RutaRepository;
import com.rutau.rutau.Service.RutaService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RutaServiceImpl implements RutaService {

    private final RutaRepository rutaRepository;

    public RutaServiceImpl(RutaRepository rutaRepository) {
        this.rutaRepository = rutaRepository;
    }

    @Override
    public Ruta crearRuta(Ruta ruta) {
        return rutaRepository.save(ruta);
    }

    @Override
    public Optional<Ruta> buscarPorId(Long id) {
        return rutaRepository.findById(id);
    }

    @Override
    public List<Ruta> buscarPorOrigenYDestino(String origen, String destino) {
        return rutaRepository.findByOrigenAndDestino(origen, destino);
    }

    @Override
    public List<Ruta> listarPorEstado(String estado) {
        return rutaRepository.findByEstado(estado);
    }

    @Override
    public void cambiarEstado(Long idRuta, String nuevoEstado) {
        Ruta ruta = rutaRepository.findById(idRuta)
                .orElseThrow(() -> new ResourceNotFoundException("Ruta no encontrada"));
        ruta.setEstado(nuevoEstado);
        rutaRepository.save(ruta);
    }
}