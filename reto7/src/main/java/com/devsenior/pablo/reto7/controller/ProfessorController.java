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

import com.devsenior.pablo.reto7.model.dto.ProfessorDto;
import com.devsenior.pablo.reto7.service.ServiceProfessor;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@Tag(name="Profesor", description="Endpoints para la gestion de profesores")
@RestController
@RequestMapping("/api/professor")
public class ProfessorController {
    private final ServiceProfessor service;

    public ProfessorController(ServiceProfessor service){
        this.service = service;
    }
    
    @Operation(summary="Obtener profesores", description="Endpoint para obtener todos los profesores. "+
    "Esta operacion es publica")
    @GetMapping
    public List<ProfessorDto> getAllProfessors() {
        return service.getAll();
    }
    
    @Operation(summary="Obtener profesor por ID", description="Endpoint para obtener un profesor por ID. "+
    "Esta operacion solo la puede realizar el rol administardor o usuario")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping("{id}")
    public ProfessorDto getProfessorById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @Operation(summary="Guardar un profesor", description="Endpoint para guardar un profesor. "+
    "Esta operacion solo la puede realizar el rol administardor")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public ProfessorDto saveProfessor(@Valid @RequestBody ProfessorDto professor) {
        return service.add(professor);
    }

    @Operation(summary="Eliminar un profesor", description="Endpoint para eliminar un profesor. "+
    "Esta operacion solo la puede realizar el rol administardor")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public ProfessorDto deleteProfessorById(@PathVariable("id") Long id) {
        return service.delete(id);
    }

    @Operation(summary="Actualizar profesor", description="Endpoint para actualizar un profesor. "+
    "Esta operacion solo la puede realizar el rol administardor")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("{id}")
    public ProfessorDto updateProfessor(@Valid @RequestBody ProfessorDto professor, @PathVariable("id") Long id) {
        return service.update(id, professor);
    }

}
