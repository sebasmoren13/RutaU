package com.rutau.rutau.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class VehiculoRequest {

    @NotBlank(message = "La placa es obligatoria")
    private String placa;

    @NotBlank(message = "El tipo es obligatorio")
    private String tipo;

    @NotNull(message = "La capacidad máxima es obligatoria")
    @Positive(message = "La capacidad debe ser mayor a cero")
    private Integer capacidadMaxima;
}