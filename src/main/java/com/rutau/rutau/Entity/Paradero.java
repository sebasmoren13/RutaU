package com.rutau.rutau.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "paraderos")
public class Paradero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String direccion;
    private Double latitud;
    private Double longitud;
    private Integer ordenParada;

    @ManyToOne
    @JoinColumn(name = "ruta_id")
    private Ruta ruta;
}