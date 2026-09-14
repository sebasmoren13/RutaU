package com.rutau.repository;

import com.rutau.entity.Abordaje;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AbordajeRepository extends JpaRepository<Abordaje, Long> {
    Optional<Abordaje> findByIdReserva(Long idReserva);
    boolean existsByIdReserva(Long idReserva);
}