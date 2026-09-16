package com.rutau.rutau.DTO.Response;

import lombok.Data;

@Data
public class UsuarioResponse {
    private Long id;
    private String nombres;
    private String identificacion;
    private String correo;
    private String rol;
    private String estado;
}