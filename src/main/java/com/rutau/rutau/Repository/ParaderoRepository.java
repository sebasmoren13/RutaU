package com.rutau.rutau.Repository;

import com.rutau.rutau.Entity.Paradero;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ParaderoRepository extends JpaRepository<Paradero, Long> {
    List<Paradero> findByRutaIdOrderByOrdenParadaAsc(Long idRuta);
}