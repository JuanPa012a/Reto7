package com.devsenior.pablo.reto7.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.pablo.reto7.Mapper.CourseMapper;
import com.devsenior.pablo.reto7.exception.CourseNotFoundException;
import com.devsenior.pablo.reto7.model.dto.CourseDto;
import com.devsenior.pablo.reto7.repository.CourseRepository;
import com.devsenior.pablo.reto7.service.ServiceCourse;

@Service
public class ServiceImplCourse implements ServiceCourse{

    private final CourseRepository repository;
    private final CourseMapper mapper;
    

    public ServiceImplCourse(CourseRepository repository, CourseMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CourseDto add(CourseDto studentDto) {
        var entity = mapper.toEntity(studentDto);
        var saveEntity = repository.save(entity);
        return mapper.toDto(saveEntity);
    }

    @Override
    public CourseDto update(Long id, CourseDto studentDto) {
        getById(id);
        var entityUpdated = mapper.toEntity(studentDto);
        entityUpdated.setId(id);
        entityUpdated = repository.save(entityUpdated);
        return mapper.toDto(entityUpdated);
    }

    @Override
    public List<CourseDto> getAll() {
        var listEntity = repository.findAll();
        if(listEntity.isEmpty())throw new CourseNotFoundException("No hay cursos registrados");    
        return mapper.toDtoList(listEntity);
    }

    @Override
    public CourseDto getById(Long id) {
      var entity = repository.findById(id).orElseThrow(
            () -> {throw new CourseNotFoundException("No se encuentra el curso con el ID: "+ id);}
        );
    return mapper.toDto(entity);
    }

    @Override
    public CourseDto delete(Long id) {
        var entity = mapper.toEntity(getById(id));
        repository.delete(entity);
        return mapper.toDto(entity);
    }
    
}
