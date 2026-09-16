package com.rutau.rutau.Service;

import com.rutau.rutau.Entity.Reserva;
import java.util.List;
import java.util.Optional;

public interface ReservaService {
    Reserva crearReserva(Long usuarioId, Long recorridoId, Long paraderoId);
    Optional<Reserva> buscarPorId(Long id);
    Optional<Reserva> buscarPorCodigoQr(String codigoQr);
    List<Reserva> listarPorUsuario(Long usuarioId);
    List<Reserva> listarPorUsuarioYEstado(Long usuarioId, String estado);
    void cancelarReserva(Long reservaId);
    boolean verificarConflictosHorario(Long usuarioId, Long recorridoId);
}