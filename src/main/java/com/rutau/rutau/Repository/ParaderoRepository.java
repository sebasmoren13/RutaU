package com.rutau.repository;

import com.rutau.entity.Paradero;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ParaderoRepository extends JpaRepository<Paradero, Long> {
    List<Paradero> findByIdRutaOrderByOrdenParadaAsc(Long idRuta);
}