package com.rutau.rutau.Service;

import com.rutau.rutau.Entity.Vehiculo;
import java.util.List;
import java.util.Optional;

public interface VehiculoService {
    Vehiculo registrarVehiculo(Vehiculo vehiculo);
    Optional<Vehiculo> buscarPorId(Long id);
    Optional<Vehiculo> buscarPorPlaca(String placa);
    List<Vehiculo> listarPorEstado(String estado);
}