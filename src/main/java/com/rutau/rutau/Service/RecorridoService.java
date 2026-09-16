package com.rutau.rutau.Service;

import com.rutau.rutau.Entity.Recorrido;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RecorridoService {
    Recorrido programarRecorrido(Recorrido recorrido);
    Optional<Recorrido> buscarPorId(Long id);
    List<Recorrido> listarPorRutaYFecha(Long rutaId, LocalDate fecha);
    List<Recorrido> listarDisponibles(Long rutaId, LocalDate fecha);
    Recorrido obtenerParaActualizarCupo(Long recorridoId);
    void cambiarEstado(Long recorridoId, String nuevoEstado);
}