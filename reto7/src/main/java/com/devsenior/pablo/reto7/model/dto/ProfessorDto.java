package com.devsenior.pablo.reto7.model.dto;


import java.util.List;

import com.devsenior.pablo.reto7.model.entities.Course;
import com.devsenior.pablo.reto7.model.entities.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ProfessorDto(
    Long id,
    @NotBlank(message="El nombre es un campo obligatorio")
    String firstName,
    @NotBlank(message="El apellido es un campo obligatorio")
    String lastName,
    String departament,
    @Email(message="El formato del correo no es valido")
    String email,
    List<Course> courses,
    User user
) {
    public ProfessorDto{
        if(courses == null) courses = List.of();
    }
}
