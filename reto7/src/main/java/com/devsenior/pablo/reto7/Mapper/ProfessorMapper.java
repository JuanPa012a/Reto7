package com.devsenior.pablo.reto7.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.devsenior.pablo.reto7.model.dto.ProfessorDto;
import com.devsenior.pablo.reto7.model.entities.Professor;

@Mapper(componentModel="spring")
public interface ProfessorMapper {
    
    ProfessorMapper INSTANCE = (ProfessorMapper) Mappers.getMapper(Professor.class);

    Professor toEntity(ProfessorDto professorDto);

    ProfessorDto toDto(Professor professor);

    List<ProfessorDto> toDtoList(List<Professor> professors);
    
    
}
