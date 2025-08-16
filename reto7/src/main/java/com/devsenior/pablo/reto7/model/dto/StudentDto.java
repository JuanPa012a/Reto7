package com.devsenior.pablo.reto7.model.dto;

import java.util.List;

import com.devsenior.pablo.reto7.model.entities.Enrollment;
import com.devsenior.pablo.reto7.model.entities.User;

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
    List<Enrollment> enrollments,
    User user
) {
   public StudentDto{
    if(enrollments == null) enrollments = List.of();
   } 
}
