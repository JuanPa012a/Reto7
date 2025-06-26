package com.devsenior.pablo.reto7.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
    @NotBlank(message="El usuario es obligatorio")
    private String username;
    @NotBlank(message="La contraseña es obligatorio")
    private String password;
}
