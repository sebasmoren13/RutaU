package com.rutau.rutau.Service;

import com.rutau.rutau.Entity.Abordaje;
import java.util.Optional;

public interface AbordajeService {
    Abordaje registrarAbordaje(String codigoQr, Long idConductor);
    Optional<Abordaje> buscarPorReserva(Long idReserva);
    boolean yaFueAbordado(Long idReserva);
}