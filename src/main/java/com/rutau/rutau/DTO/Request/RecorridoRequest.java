package com.rutau.rutau.DTO.Request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class RecorridoRequest {

    @NotNull(message = "La ruta es obligatoria")
    private Long rutaId;

    @NotNull(message = "El vehículo es obligatorio")
    private Long vehiculoId;

    @NotNull(message = "El conductor es obligatorio")
    private Long conductorId;

    @NotNull(message = "La fecha es obligatoria")
    private LocalDate fecha;

    @NotNull(message = "La hora de salida es obligatoria")
    private LocalTime horaSalida;

    @NotNull(message = "La hora de llegada es obligatoria")
    private LocalTime horaLlegada;

    @NotNull(message = "Los cupos son obligatorios")
    @Positive(message = "Los cupos deben ser mayores a cero")
    private Integer cuposDisponibles;
}