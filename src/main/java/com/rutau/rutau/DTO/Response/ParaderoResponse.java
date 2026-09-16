package com.rutau.rutau.DTO.Response;

import lombok.Data;

@Data
public class ParaderoResponse {
    private Long id;
    private String nombre;
    private String direccion;
    private Double latitud;
    private Double longitud;
    private Integer ordenParada;
    private Long rutaId;
}