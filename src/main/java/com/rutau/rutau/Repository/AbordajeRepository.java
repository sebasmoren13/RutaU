package com.rutau.rutau.Repository;

import com.rutau.rutau.Entity.Abordaje;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AbordajeRepository extends JpaRepository<Abordaje, Long> {
    Optional<Abordaje> findByIdReserva(Long idReserva);
    boolean existsByIdReserva(Long idReserva);
}