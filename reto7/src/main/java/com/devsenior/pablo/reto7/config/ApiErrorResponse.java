package com.devsenior.pablo.reto7.config;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiErrorResponse {
    
    // @JsonFormat asegura que la fecha se serialice a un formato legible por humanos
    // ISO 8601 es el estándar para fechas en APIs REST
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;

    private Integer status; // Código de estado HTTP numérico (ej: 400, 404)
    private String error;   // La frase del estado HTTP (ej: "Bad Request", "Not Found")
    private String message; // Mensaje detallado del error para el cliente
    private String path;    // La URI de la solicitud que causó el error

    // Constructor que inicializa los campos
    public ApiErrorResponse(HttpStatus status, String message, String path) {
        this.timestamp = LocalDateTime.now(); // Obtiene la fecha y hora actual
        this.status = status.value();         // Convierte el enum HttpStatus a su valor numérico
        this.error = status.getReasonPhrase(); // Obtiene la frase descriptiva del HttpStatus
        this.message = message;
        this.path = path;
    }

    // Getters para que Jackson pueda serializar los campos a JSON
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    // Los setters no son estrictamente necesarios si solo vamos a construir el objeto
    // en el constructor y luego serializarlo, pero pueden añadirlos si lo necesitan.
}
