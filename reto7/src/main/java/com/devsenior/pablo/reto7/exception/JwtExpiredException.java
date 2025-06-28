package com.devsenior.pablo.reto7.exception;

public class JwtExpiredException extends RuntimeException{
    public JwtExpiredException(String message){
        super("La cuenta ha expirado, autenticate nuevamente: "+message);
    }
}
