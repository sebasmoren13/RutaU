package com.rutau.rutau.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String token;
    private String tipo; // "Bearer"
    private Long usuarioId;
    private String correo;
    private String rol;
}