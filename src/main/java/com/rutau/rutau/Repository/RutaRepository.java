package com.rutau.repository;

import com.rutau.entity.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RutaRepository extends JpaRepository<Ruta, Long> {
    List<Ruta> findByOrigenAndDestino(String origen, String destino);
    List<Ruta> findByEstado(String estado);
}