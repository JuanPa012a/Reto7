package com.devsenior.pablo.reto7.service;

import java.util.List;

import com.devsenior.pablo.reto7.model.dto.ProfessorDto;



public interface ServiceProfessor {
    
    ProfessorDto add(ProfessorDto studentDto);

    ProfessorDto update(Long id, ProfessorDto studentDto);

    List<ProfessorDto> getAll();
    
    ProfessorDto getById(Long id);

    ProfessorDto delete(Long id);

}
