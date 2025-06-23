package com.devsenior.pablo.reto7.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.pablo.reto7.Mapper.ProfessorMapper;
import com.devsenior.pablo.reto7.exception.ProfessorNotFoundException;
import com.devsenior.pablo.reto7.model.dto.ProfessorDto;
import com.devsenior.pablo.reto7.repository.ProfessorRepository;
import com.devsenior.pablo.reto7.service.ServiceProfessor;

@Service
public class ServiceImplProfessor implements ServiceProfessor{

    private final ProfessorRepository repository;
    private final ProfessorMapper mapper;
    

    public ServiceImplProfessor(ProfessorRepository repository, ProfessorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ProfessorDto add(ProfessorDto professorDto) {
        var entity = mapper.toEntity(professorDto);
        var saveEntity = repository.save(entity);
        return mapper.toDto(saveEntity);
    }

    @Override
    public ProfessorDto update(Long id, ProfessorDto professorDto) {
        getById(id);
        var entityUpdated = mapper.toEntity(professorDto);
        entityUpdated.setId(id);
        entityUpdated = repository.save(entityUpdated);
        return mapper.toDto(entityUpdated);
    }

    @Override
    public List<ProfessorDto> getAll() {
        var listEntity = repository.findAll();
        if(listEntity.isEmpty())throw new ProfessorNotFoundException("No hay profesores registrados");    
        return mapper.toDtoList(listEntity);
    }

    @Override
    public ProfessorDto getById(Long id) {
      var entity = repository.findById(id).orElseThrow(
            () -> {throw new ProfessorNotFoundException("No se encuentra el profesor con el ID: "+ id);}
        );
    return mapper.toDto(entity);
    }

    @Override
    public ProfessorDto delete(Long id) {
        var entity = mapper.toEntity(getById(id));
        repository.delete(entity);
        return mapper.toDto(entity);
    }
    
}
