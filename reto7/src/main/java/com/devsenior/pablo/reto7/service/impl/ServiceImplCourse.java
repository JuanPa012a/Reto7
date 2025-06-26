package com.devsenior.pablo.reto7.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.pablo.reto7.Mapper.CourseMapper;
import com.devsenior.pablo.reto7.exception.CourseNotFoundException;
import com.devsenior.pablo.reto7.exception.ProfessorNotFoundException;
import com.devsenior.pablo.reto7.model.dto.CourseDto;
import com.devsenior.pablo.reto7.model.entities.Professor;
import com.devsenior.pablo.reto7.repository.CourseRepository;
import com.devsenior.pablo.reto7.repository.ProfessorRepository;
import com.devsenior.pablo.reto7.service.ServiceCourse;

@Service
public class ServiceImplCourse implements ServiceCourse{

    private final CourseRepository repository;
    private final ProfessorRepository professorRepository;
    private final CourseMapper mapper;
    

    public ServiceImplCourse(CourseRepository repository, CourseMapper mapper,
    ProfessorRepository professorRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.professorRepository = professorRepository;
    }

    @Override
    public CourseDto add(CourseDto courseDto) {
        var entity = mapper.toEntity(courseDto);
        var professor = getProfessorById(courseDto.professor_id());
        entity.setProfessor(professor);
        var saveEntity = repository.save(entity);
        return mapper.toDto(saveEntity);
    }

    @Override
    public CourseDto update(Long id, CourseDto courseDto) {
        getById(id);
        var entityUpdated = mapper.toEntity(courseDto);
        var professor = getProfessorById(courseDto.professor_id());
        entityUpdated.setProfessor(professor);
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

    private Professor getProfessorById(Long id){
        return professorRepository.findById(id).orElseThrow(
            () -> new ProfessorNotFoundException("No se encuentra el profesor con el ID: " + id)
        );
    }
    
}
