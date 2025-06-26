package com.devsenior.pablo.reto7.service;

import com.devsenior.pablo.reto7.model.dto.AuthenticationRequest;
import com.devsenior.pablo.reto7.model.dto.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse login(AuthenticationRequest credentials);
    void saveUser(AuthenticationRequest credentials, String rol);
}
