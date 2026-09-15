package com.rutau.rutau.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Data
@Entity
@Table(name = "abordajes")
public class Abordaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "reserva_id", unique = true)
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "conductor_id")
    private Usuario conductor;

    private LocalTime horaLectura;
    private String observacion;
    private String estadoValidacion;
}