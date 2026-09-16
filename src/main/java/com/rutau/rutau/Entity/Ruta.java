package com.rutau.rutau.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rutas")
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String origen;
    private String destino;
    private String estado;
}