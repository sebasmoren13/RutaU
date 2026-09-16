package com.rutau.rutau.Service;

import com.rutau.rutau.Entity.Abordaje;
import java.util.Optional;

public interface AbordajeService {
    Abordaje registrarAbordaje(String codigoQr, Long conductorId);
    Optional<Abordaje> buscarPorReserva(Long reservaId);
    boolean yaFueAbordado(Long reservaId);
}