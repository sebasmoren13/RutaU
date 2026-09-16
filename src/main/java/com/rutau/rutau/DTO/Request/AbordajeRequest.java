package com.rutau.rutau.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AbordajeRequest {

    @NotBlank(message = "El código QR es obligatorio")
    private String codigoQr;

    @NotNull(message = "El conductor es obligatorio")
    private Long conductorId;
}