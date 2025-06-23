package com.devsenior.pablo.reto7.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.devsenior.pablo.reto7.model.entities.Enrollment;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record StudentDto(
    
    Long id,
    @NotBlank(message="El nombre es un campo obligatorio")
    String firstName,
    @NotBlank(message="El apellido es un campo obligatorio")
    String lastName,
    @Email(message="El formato no es adecuado del correo")
    String email,
    @NotBlank(message="El numero de telefono es un campo obligatorio")
    String phone,
    List<Enrollment> enrollments
) {
   public StudentDto{
    if(enrollments == null) enrollments = new ArrayList<>();
   } 
}
