package com.rutau.rutau.DTO.Response;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class RecorridoResponse {
    private Long id;
    private Long rutaId;
    private String rutaNombre;
    private Long vehiculoId;
    private String vehiculoPlaca;
    private Long conductorId;
    private String conductorNombre;
    private LocalDate fecha;
    private LocalTime horaSalida;
    private LocalTime horaLlegada;
    private Integer cuposDisponibles;
    private String estado;
}