package com.rutau.rutau.Service;

import com.rutau.rutau.Entity.Recorrido;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RecorridoService {
    Recorrido programarRecorrido(Recorrido recorrido);
    Optional<Recorrido> buscarPorId(Long id);
    List<Recorrido> listarPorRutaYFecha(Long idRuta, LocalDate fecha);
    List<Recorrido> listarDisponibles(Long idRuta, LocalDate fecha);
    Recorrido obtenerParaActualizarCupo(Long idRecorrido);
    void cambiarEstado(Long idRecorrido, String nuevoEstado);
}