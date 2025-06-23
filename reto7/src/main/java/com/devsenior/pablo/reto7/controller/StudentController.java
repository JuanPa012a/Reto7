package com.devsenior.pablo.reto7.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
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

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final ServiceStudent service;

    public StudentController(ServiceStudent service){
        this.service = service;
    }
    
    @GetMapping
    public List<StudentDto> getAllStudents() {
        return service.getAll();
    }
    
    @GetMapping("{id}")
    public StudentDto getStudentById(@PathVariable Long id) {
        return service.getById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public StudentDto saveStudent(@Valid @RequestBody StudentDto student) {
        return service.add(student);
    }
    
    @DeleteMapping("{id}")
    public StudentDto deleteStudentById(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("{id}")
    public StudentDto saveStudent(@Valid @RequestBody StudentDto student, @PathVariable Long id) {
        return service.update(id, student);
    }

}
