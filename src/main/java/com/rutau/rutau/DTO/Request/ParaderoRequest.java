package com.rutau.rutau.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ParaderoRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;

    @NotNull(message = "La latitud es obligatoria")
    private Double latitud;

    @NotNull(message = "La longitud es obligatoria")
    private Double longitud;

    @NotNull(message = "El orden de parada es obligatorio")
    @Positive(message = "El orden debe ser mayor a cero")
    private Integer ordenParada;

    @NotNull(message = "La ruta es obligatoria")
    private Long rutaId;
}