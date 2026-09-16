package com.rutau.rutau.DTO.Response;

import lombok.Data;

@Data
public class RutaResponse {
    private Long id;
    private String nombre;
    private String origen;
    private String destino;
    private String estado;
}