package com.rutau.rutau.Repository;

import com.rutau.rutau.Entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findByUsuarioId(Long idUsuario);

    Optional<Reserva> findByCodigoQr(String codigoQr);

    List<Reserva> findByUsuarioIdAndEstado(Long idUsuario, String estado);

    @Query("SELECT r FROM Reserva r WHERE r.usuario.id = :idUsuario " +
            "AND r.estado = 'Pendiente' AND r.recorrido.id = :idRecorrido")
    List<Reserva> findConflictos(@Param("idUsuario") Long idUsuario,
                                 @Param("idRecorrido") Long idRecorrido);
}