package com.devsenior.pablo.reto7.service;

import java.util.List;

import com.devsenior.pablo.reto7.model.dto.EnrollmentDto;


public interface ServiceEnrollment {
    
    EnrollmentDto add(EnrollmentDto studentDto);

    EnrollmentDto update(Long id, EnrollmentDto studentDto);

    List<EnrollmentDto> getAll();
    
    EnrollmentDto getById(Long id);

    EnrollmentDto delete(Long id);

}
