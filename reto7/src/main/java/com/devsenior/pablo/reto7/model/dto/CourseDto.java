package com.devsenior.pablo.reto7.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.devsenior.pablo.reto7.model.entities.Enrollment;
import com.devsenior.pablo.reto7.model.entities.Professor;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CourseDto(

    Long id,
    @NotBlank(message="El nombre del curso es un campo obligatorio")
    String name,
    String code,
    String description,
    @Min(value= 1,
        message="La cantidad no puede ser menor a 1")
    Integer maxAmount,
    @NotNull(message="El docente del curso es un campo obligatorio")
    Long professor_id,
    List<Enrollment> enrollments,
    Professor professor

) {
    public CourseDto{
        if(enrollments == null) enrollments = new ArrayList<>();
        code = "";
        
    }
    
}
