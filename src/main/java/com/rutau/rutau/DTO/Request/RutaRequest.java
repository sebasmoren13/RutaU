package com.rutau.rutau.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RutaRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El origen es obligatorio")
    private String origen;

    @NotBlank(message = "El destino es obligatorio")
    private String destino;
}