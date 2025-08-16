package com.devsenior.pablo.reto7.model.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.devsenior.pablo.reto7.model.Status;
import com.devsenior.pablo.reto7.model.entities.Course;
import com.devsenior.pablo.reto7.model.entities.Student;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record EnrollmentDto(
    Long id,
    @NotNull(message="El campo del estudiante es obligatorio")
    Long studentId,
    @NotNull(message="El campo del curso es obligatorio")
    Long courseId,
    LocalDateTime startDate,
    String status,
    List<Student> students,
    List<Course> courses
) {
    public EnrollmentDto{
        if(students == null ) students = List.of();
        if(courses == null) courses = List.of();
        if(status == null) status = Status.ACTIVO.name();
        if(startDate == null) startDate = LocalDateTime.now();
    }
    
}
