package com.rutau.rutau.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombres;
    private String identificacion;
    private String correo;
    private String passwordHash;
    private String rol;
    private String estado;

    private Integer noShowsCount;
    private LocalDateTime bloqueadoHasta;
}