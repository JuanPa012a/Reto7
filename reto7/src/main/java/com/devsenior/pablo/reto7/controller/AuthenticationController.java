package com.devsenior.pablo.reto7.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.pablo.reto7.model.dto.AuthenticationRequest;
import com.devsenior.pablo.reto7.model.dto.AuthenticationResponse;
import com.devsenior.pablo.reto7.service.impl.AuthenticationServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
    
@Tag(name="Autenticacion", description="Endpoints para auntenticarse y registrarse en el sistema")
@RestController
@AllArgsConstructor
public class AuthenticationController {
    
    private final AuthenticationServiceImpl service;
    


    @Operation(summary="Auntenticacion", description="Aca es donde nos vamos a autenticar en el sistema y recibir nuestras credenciales JWT")
    @PostMapping("/authenticate")
    public AuthenticationResponse login(@Valid @RequestBody AuthenticationRequest request) throws Exception {
        return service.login(request);
    }
    @Operation(summary="Register", description="Podemos crear nuestro propio usuario para poder entrar al sistema")
    @PostMapping("/register")
    public ResponseEntity<HttpStatus> register(@Valid @RequestBody AuthenticationRequest entity, @RequestParam("rol") String rol) {
        service.saveUser(entity, rol);
        return ResponseEntity.ok().build();
    }

    
    
}
