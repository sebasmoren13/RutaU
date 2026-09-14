package com.rutau.repository;

import com.rutau.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findByIdUsuario(Long idUsuario);

    Optional<Reserva> findByCodigoQr(String codigoQr);

    List<Reserva> findByIdUsuarioAndEstado(Long idUsuario, String estado);

    // Para validar traslape de horarios (RN02)
    @Query("SELECT r FROM Reserva r WHERE r.idUsuario = :idUsuario " +
            "AND r.estado = 'Pendiente' AND r.idRecorrido = :idRecorrido")
    List<Reserva> findConflictos(@Param("idUsuario") Long idUsuario,
                                 @Param("idRecorrido") Long idRecorrido);
}