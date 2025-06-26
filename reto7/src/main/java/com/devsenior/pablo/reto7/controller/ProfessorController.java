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

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/professor")
public class ProfessorController {
    private final ServiceProfessor service;

    public ProfessorController(ServiceProfessor service){
        this.service = service;
    }
    
    @GetMapping
    public List<ProfessorDto> getAllProfessors() {
        return service.getAll();
    }
    
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping("{id}")
    public ProfessorDto getProfessorById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public ProfessorDto saveProfessor(@Valid @RequestBody ProfessorDto professor) {
        return service.add(professor);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public ProfessorDto deleteProfessorById(@PathVariable Long id) {
        return service.delete(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("{id}")
    public ProfessorDto updateProfessor(@Valid @RequestBody ProfessorDto professor, @PathVariable Long id) {
        return service.update(id, professor);
    }

}
