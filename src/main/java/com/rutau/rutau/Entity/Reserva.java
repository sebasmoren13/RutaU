package com.rutau.rutau.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "recorrido_id")
    private Recorrido recorrido;

    @ManyToOne
    @JoinColumn(name = "paradero_id")
    private Paradero paradero;

    private String codigoQr;
    private LocalDateTime fechaCreacion;
    private String estado;
}