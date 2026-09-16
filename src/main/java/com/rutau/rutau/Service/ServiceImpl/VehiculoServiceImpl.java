package com.rutau.rutau.Service.ServiceImpl;

import com.rutau.rutau.Entity.Vehiculo;
import com.rutau.rutau.Repository.VehiculoRepository;
import com.rutau.rutau.Service.VehiculoService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    public VehiculoServiceImpl(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public Vehiculo registrarVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public Optional<Vehiculo> buscarPorId(Long id) {
        return vehiculoRepository.findById(id);
    }

    @Override
    public Optional<Vehiculo> buscarPorPlaca(String placa) {
        return vehiculoRepository.findByPlaca(placa);
    }

    @Override
    public List<Vehiculo> listarPorEstado(String estado) {
        return vehiculoRepository.findByEstado(estado);
    }
}