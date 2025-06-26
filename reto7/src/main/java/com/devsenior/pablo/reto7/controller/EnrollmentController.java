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

import com.devsenior.pablo.reto7.model.dto.EnrollmentDto;
import com.devsenior.pablo.reto7.service.ServiceEnrollment;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/enrollment")
public class EnrollmentController {
    private final ServiceEnrollment service;

    public EnrollmentController(ServiceEnrollment service){
        this.service = service;
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<EnrollmentDto> getAllEnrollments() {
        return service.getAll();
    }
    
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping("{id}")
    public EnrollmentDto getEnrollmentById(@PathVariable Long id) {
        return service.getById(id);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public EnrollmentDto saveEnrollment(@Valid @RequestBody EnrollmentDto enrollment) {
        return service.add(enrollment);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public EnrollmentDto deleteEnrollmentById(@PathVariable Long id) {
        return service.delete(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("{id}")
    public EnrollmentDto updateEnrollment(@Valid @RequestBody EnrollmentDto enrollment, @PathVariable Long id) {
        return service.update(id, enrollment);
    }

}
