package com.rutau.rutau.DTO.Response;

import lombok.Data;

@Data
public class VehiculoResponse {
    private Long id;
    private String placa;
    private String tipo;
    private Integer capacidadMaxima;
    private String estado;
}