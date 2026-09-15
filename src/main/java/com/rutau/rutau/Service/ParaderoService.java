package com.rutau.rutau.Service;

import com.rutau.rutau.Entity.Paradero;
import java.util.List;
import java.util.Optional;

public interface ParaderoService {
    Paradero crearParadero(Paradero paradero);
    Optional<Paradero> buscarPorId(Long id);
    List<Paradero> obtenerParaderosPorRuta(Long idRuta);
    void actualizarUbicacion(Long idParadero, Double latitud, Double longitud);
}