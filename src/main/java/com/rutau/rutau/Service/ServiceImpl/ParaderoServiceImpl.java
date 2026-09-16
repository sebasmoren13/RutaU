package com.rutau.rutau.Service.ServiceImpl;

import com.rutau.rutau.Entity.Paradero;
import com.rutau.rutau.Exception.ResourceNotFoundException;
import com.rutau.rutau.Repository.ParaderoRepository;
import com.rutau.rutau.Service.ParaderoService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ParaderoServiceImpl implements ParaderoService {

    private final ParaderoRepository paraderoRepository;

    public ParaderoServiceImpl(ParaderoRepository paraderoRepository) {
        this.paraderoRepository = paraderoRepository;
    }

    @Override
    public Paradero crearParadero(Paradero paradero) {
        return paraderoRepository.save(paradero);
    }

    @Override
    public Optional<Paradero> buscarPorId(Long id) {
        return paraderoRepository.findById(id);
    }

    @Override
    public List<Paradero> obtenerParaderosPorRuta(Long idRuta) {
        return paraderoRepository.findByIdRutaOrderByOrdenParadaAsc(idRuta);
    }

    @Override
    public void actualizarUbicacion(Long idParadero, Double latitud, Double longitud) {
        Paradero paradero = paraderoRepository.findById(idParadero)
                .orElseThrow(() -> new ResourceNotFoundException("Paradero no encontrado"));
        paradero.setLatitud(latitud);
        paradero.setLongitud(longitud);
        paraderoRepository.save(paradero);
    }
}