package com.rutau.rutau.Repository;

import com.rutau.rutau.Entity.Recorrido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jakarta.persistence.LockModeType;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RecorridoRepository extends JpaRepository<Recorrido, Long> {

    List<Recorrido> findByIdRutaAndFecha(Long idRuta, LocalDate fecha);

    @Query("SELECT r FROM Recorrido r WHERE r.idRuta = :idRuta " +
            "AND r.fecha = :fecha AND r.cupos_disponibles > 0")
    List<Recorrido> findDisponiblesPorRutaYFecha(@Param("idRuta") Long idRuta,
                                                 @Param("fecha") LocalDate fecha);

    // Pesimista: evita condiciones de carrera al descontar cupo (RN01/RN08)
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT r FROM Recorrido r WHERE r.id = :id")
    Optional<Recorrido> findByIdForUpdate(@Param("id") Long id);
}