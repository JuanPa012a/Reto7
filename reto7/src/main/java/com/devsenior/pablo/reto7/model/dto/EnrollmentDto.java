package com.devsenior.pablo.reto7.model.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.devsenior.pablo.reto7.model.Status;
import com.devsenior.pablo.reto7.model.entities.Course;
import com.devsenior.pablo.reto7.model.entities.Student;

import jakarta.validation.constraints.NotNull;

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
        if(students == null ) students = new ArrayList<>();
        if(courses == null) courses = new ArrayList<>();
        status = Status.ACTIVO.name();
        startDate = LocalDateTime.now();
    }
    
}
