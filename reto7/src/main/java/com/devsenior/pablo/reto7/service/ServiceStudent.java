package com.devsenior.pablo.reto7.service;

import java.util.List;

import com.devsenior.pablo.reto7.model.dto.StudentDto;

public interface ServiceStudent {
    
    StudentDto add(StudentDto studentDto);

    StudentDto update(Long id, StudentDto studentDto);

    List<StudentDto> getAll();
    
    StudentDto getById(Long id);

    StudentDto delete(Long id);

}
