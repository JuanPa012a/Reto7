package com.devsenior.pablo.reto7.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.pablo.reto7.model.dto.CourseDto;
import com.devsenior.pablo.reto7.service.ServiceCourse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@Tag(name="Cursos", description="Endpoints de la gestion de cursos")
@RestController
@RequestMapping("/api/course")
public class CourseController {
    private final ServiceCourse service;

    public CourseController(ServiceCourse service){
        this.service = service;
    }
    
    @Operation(summary="Listar los cursos", description="Listar todos los cursos que existan en el sistema.")
    @GetMapping
    public List<CourseDto> getAllCourses() {
        return service.getAll();
    }

    @Operation(summary="Obtener curso por Id", description="Se obtiene un curso por su Id. "+
    "Esta operacion solo la puede realizar el rol administardor o usuario")
    @PreAuthorize("hasRole('ADMIN') or (hasRole('USER') and #id > 0) ")
    @GetMapping("{id}")
    public CourseDto getCourseById(@PathVariable Long id) {
        return service.getById(id);
    }
    
    @Operation(summary="Crear curso", description="Endpoint para crear un curso. "+
    "Esta operacion solo la puede realizar el rol administardor")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public CourseDto saveCourse(@Valid @RequestBody CourseDto course) {
        return service.add(course);
    }
    
    @Operation(summary="Eliminar curso", description="Endpoint para eliminar un curso. "+
    "Esta operacion solo la puede realizar el rol administardor")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public CourseDto deleteCourseById(@PathVariable Long id) {
        return service.delete(id);
    }

    @Operation(summary="Actualizar curso", description="Endpoint para actualizar un curso. "+
    "Esta operacion solo la puede realizar el rol administardor")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("{id}")
    public CourseDto updateCourse(@Valid @RequestBody CourseDto course, @PathVariable Long id) {
        return service.update(id, course);
    }

}
