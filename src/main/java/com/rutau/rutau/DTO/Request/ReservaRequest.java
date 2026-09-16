package com.rutau.rutau.DTO.Request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReservaRequest {

    @NotNull(message = "El usuario es obligatorio")
    private Long usuarioId;

    @NotNull(message = "El recorrido es obligatorio")
    private Long recorridoId;

    @NotNull(message = "El paradero es obligatorio")
    private Long paraderoId;
}