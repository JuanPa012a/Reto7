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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.pablo.reto7.model.dto.EnrollmentDto;
import com.devsenior.pablo.reto7.service.ServiceEnrollment;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@Tag(name="Inscripcion", description="Endpoints para la gestion de inscripciones")
@RestController
@RequestMapping("/api/enrollment")
public class EnrollmentController {
    private final ServiceEnrollment service;

    public EnrollmentController(ServiceEnrollment service){
        this.service = service;
    }
    @Operation(summary="Obtener inscripciones", description="Endpoint para obtener todas las inscripciones. "+
    "Esta operacion solo la puede realizar el rol administardor")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<EnrollmentDto> getAllEnrollments() {
        return service.getAll();
    }

    @Operation(summary="Obtener inscripcion por ID", description="Endpoint para obtener una inscripcion por ID. "+
    "Esta operacion solo la puede realizar el rol administardor y usuario")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping("{id}")
    public EnrollmentDto getEnrollmentById(@PathVariable Long id) {
        return service.getById(id);
    }

    @Operation(summary="Guardar Inscripcion", description="Endpoint para guardar una inscripcion. "+
    "Esta operacion solo la puede realizar el rol administardor")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public EnrollmentDto saveEnrollment(@Valid @RequestBody EnrollmentDto enrollment) {
        return service.add(enrollment);
    }
    
    @Operation(summary="Eliminar una inscripcion", description="Endpoint para eliminar una inscripcion. "+
    "Esta operacion solo la puede realizar el rol administardor")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public EnrollmentDto deleteEnrollmentById(@PathVariable Long id) {
        return service.delete(id);
    }

    @Operation(summary="Actualizar una inscripcion", description="Endpoint para actualizar una inscripcion. "+
    "Esta operacion solo la puede realizar el rol administardor")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("{id}")
    public EnrollmentDto updateEnrollment(@Valid @RequestBody EnrollmentDto enrollment, @PathVariable Long id) {
        return service.update(id, enrollment);
    }

    @Operation(summary="Cambiar estado de la Inscripcion", description="Endpoint para cambiar el estado de una inscripcion. "+
    "Esta operacion solo la puede realizar el rol administardor")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/estado")
    public EnrollmentDto changeStatus(@RequestParam Long id,
                                 @RequestParam String status) {
        return service.changeStatus(id, status);
    }
    

}
