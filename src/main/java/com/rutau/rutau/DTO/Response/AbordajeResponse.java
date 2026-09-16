package com.rutau.rutau.DTO.Response;

import lombok.Data;

import java.time.LocalTime;

@Data
public class AbordajeResponse {
    private Long id;
    private Long reservaId;
    private Long conductorId;
    private String conductorNombre;
    private LocalTime horaLectura;
    private String observacion;
    private String estadoValidacion;
}