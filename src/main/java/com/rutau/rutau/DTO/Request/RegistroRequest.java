package com.rutau.rutau.DTO.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegistroRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombres;

    @NotBlank(message = "La identificación es obligatoria")
    private String identificacion;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo no tiene un formato válido")
    private String correo;

    @NotBlank(message = "La contraseña es obligatoria")
    private String password;

    @NotBlank(message = "El rol es obligatorio")
    private String rol;
}