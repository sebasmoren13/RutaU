package com.rutau.rutau.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "recorridos")
public class Recorrido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ruta_id")
    private Ruta ruta;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "conductor_id")
    private Usuario conductor;

    private LocalDate fecha;
    private LocalTime horaSalida;
    private LocalTime horaLlegada;
    private Integer cuposDisponibles;
    private String estado;

    @Version
    private Long version;
}