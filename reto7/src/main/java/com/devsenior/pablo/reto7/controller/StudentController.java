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

import com.devsenior.pablo.reto7.model.dto.StudentDto;
import com.devsenior.pablo.reto7.service.ServiceStudent;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@Tag(name="Estudiantes", description="Endpoint para la gestion de estudiantes")
@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final ServiceStudent service;

    public StudentController(ServiceStudent service){
        this.service = service;
    }
    
    @Operation(summary="Obtener estudantes", description="Endpoint para obtener todos los estudiantes. "+
    "Esta operacion es publica")
    @GetMapping
    public List<StudentDto> getAllStudents() {
        return service.getAll();
    }
    
    @Operation(summary="Obtener estudiante por ID", description="Endpoint para obtener un estudiante por ID. "+
    "Esta operacion solo la puede realizar el rol administardor o usuario")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping("{id}")
    public StudentDto getStudentById(@PathVariable Long id) {
        return service.getById(id);
    }

    @Operation(summary="Guardar un estudiante", description="Endpoint para guardar un estudiante. "+
    "Esta operacion solo la puede realizar el rol administardor")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public StudentDto saveStudent(@Valid @RequestBody StudentDto student) {
        return service.add(student);
    }
    
    @Operation(summary="Eliminar un estudiante", description="Endpoint para guardar un estudiante. "+
    "Esta operacion solo la puede realizar el rol administardor")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public StudentDto deleteStudentById(@PathVariable Long id) {
        return service.delete(id);
    }

    @Operation(summary="Actualizar un estudiante", description="Endpoint para actualizar un estudiante. "+
    "Esta operacion solo la puede realizar el rol administardor")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @PutMapping("{id}")
    public StudentDto updateStudent(@Valid @RequestBody StudentDto student, @PathVariable Long id) {
        return service.update(id, student);
    }

}
