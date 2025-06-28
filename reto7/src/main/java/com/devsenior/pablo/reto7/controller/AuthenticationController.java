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

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
    

@RestController
@AllArgsConstructor
public class AuthenticationController {
    
    private final AuthenticationServiceImpl service;
    



    @PostMapping("/authenticate")
    public AuthenticationResponse login(@Valid @RequestBody AuthenticationRequest request) throws Exception {
        return service.login(request);
    }

    @PostMapping("/register")
    public ResponseEntity<HttpStatus> register(@Valid @RequestBody AuthenticationRequest entity, @RequestParam("rol") String rol) {
        service.saveUser(entity, rol);
        return ResponseEntity.ok().build();
    }

    
    
}
