package com.devsenior.pablo.reto7.service;

import java.util.List;

import com.devsenior.pablo.reto7.model.dto.EnrollmentDto;


public interface ServiceEnrollment {
    
    EnrollmentDto add(EnrollmentDto enrollmentDto);

    EnrollmentDto update(Long id, EnrollmentDto enrollmentDto);

    List<EnrollmentDto> getAll();
    
    EnrollmentDto getById(Long id);

    EnrollmentDto delete(Long id);

    EnrollmentDto changeStatus(Long id, String status);


}
