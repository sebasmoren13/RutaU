package com.rutau.rutau.Service;

import com.rutau.rutau.Entity.Reserva;
import java.util.List;
import java.util.Optional;

public interface ReservaService {
    Reserva crearReserva(Long idUsuario, Long idRecorrido, Long idParadero);
    Optional<Reserva> buscarPorId(Long id);
    Optional<Reserva> buscarPorCodigoQr(String codigoQr);
    List<Reserva> listarPorUsuario(Long idUsuario);
    List<Reserva> listarPorUsuarioYEstado(Long idUsuario, String estado);
    void cancelarReserva(Long idReserva);
    boolean verificarConflictosHorario(Long idUsuario, Long idRecorrido);
}