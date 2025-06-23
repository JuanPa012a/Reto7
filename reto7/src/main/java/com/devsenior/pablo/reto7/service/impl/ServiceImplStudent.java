package com.devsenior.pablo.reto7.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.pablo.reto7.Mapper.StudentMapper;
import com.devsenior.pablo.reto7.exception.StudentNotFoundException;
import com.devsenior.pablo.reto7.model.dto.StudentDto;
import com.devsenior.pablo.reto7.repository.StudentRepository;
import com.devsenior.pablo.reto7.service.ServiceStudent;

@Service
public class ServiceImplStudent implements ServiceStudent{

    private final StudentRepository repository;
    private final StudentMapper mapper;
    

    public ServiceImplStudent(StudentRepository repository, StudentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public StudentDto add(StudentDto studentDto) {
        var entity = mapper.toEntity(studentDto);
        var saveEntity = repository.save(entity);
        return mapper.toDto(saveEntity);
    }

    @Override
    public StudentDto update(Long id, StudentDto studentDto) {
        getById(id);
        var entityUpdated = mapper.toEntity(studentDto);
        entityUpdated.setId(id);
        entityUpdated = repository.save(entityUpdated);
        return mapper.toDto(entityUpdated);
    }

    @Override
    public List<StudentDto> getAll() {
        var listEntity = repository.findAll();
        if(listEntity.isEmpty())throw new StudentNotFoundException("No hay estudiantes registrados");    
        return mapper.toDtoList(listEntity);
    }

    @Override
    public StudentDto getById(Long id) {
      var entity = repository.findById(id).orElseThrow(
            () -> {throw new StudentNotFoundException("No se encuentra el estudiante con el ID: "+ id);}
        );
    return mapper.toDto(entity);
    }

    @Override
    public StudentDto delete(Long id) {
        var entity = mapper.toEntity(getById(id));
        repository.delete(entity);
        return mapper.toDto(entity);
    }
    
}
