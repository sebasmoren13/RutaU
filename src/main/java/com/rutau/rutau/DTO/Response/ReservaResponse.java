package com.rutau.rutau.DTO.Response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservaResponse {
    private Long id;
    private Long usuarioId;
    private String usuarioNombre;
    private Long recorridoId;
    private Long paraderoId;
    private String paraderoNombre;
    private String codigoQr;
    private LocalDateTime fechaCreacion;
    private String estado;
}