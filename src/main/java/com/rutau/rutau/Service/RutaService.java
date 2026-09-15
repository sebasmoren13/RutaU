package com.rutau.rutau.Service;

import com.rutau.rutau.Entity.Ruta;
import java.util.List;
import java.util.Optional;

public interface RutaService {
    Ruta crearRuta(Ruta ruta);
    Optional<Ruta> buscarPorId(Long id);
    List<Ruta> buscarPorOrigenYDestino(String origen, String destino);
    List<Ruta> listarPorEstado(String estado);
    void cambiarEstado(Long idRuta, String nuevoEstado);
}