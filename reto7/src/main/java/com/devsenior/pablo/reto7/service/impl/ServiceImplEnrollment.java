package com.devsenior.pablo.reto7.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.pablo.reto7.Mapper.EnrollmentMapper;
import com.devsenior.pablo.reto7.exception.CourseNotFoundException;
import com.devsenior.pablo.reto7.exception.EnrollmentNotFoundException;
import com.devsenior.pablo.reto7.exception.StudentNotFoundException;
import com.devsenior.pablo.reto7.model.dto.EnrollmentDto;
import com.devsenior.pablo.reto7.model.entities.Course;
import com.devsenior.pablo.reto7.model.entities.Student;
import com.devsenior.pablo.reto7.repository.CourseRepository;
import com.devsenior.pablo.reto7.repository.EnrollmentRepository;
import com.devsenior.pablo.reto7.repository.StudentRepository;
import com.devsenior.pablo.reto7.service.ServiceEnrollment;

@Service
public class ServiceImplEnrollment implements ServiceEnrollment{

    private final EnrollmentRepository repository;
    private final EnrollmentMapper mapper;
    private final StudentRepository repositoryStudent;
    private final CourseRepository repositoryCourse;
    

    public ServiceImplEnrollment(EnrollmentRepository repository, EnrollmentMapper mapper,
    StudentRepository repositoryStudent, CourseRepository repositoryCourse) {
        this.repository = repository;
        this.mapper = mapper;
        this.repositoryStudent = repositoryStudent;
        this.repositoryCourse = repositoryCourse;
        
    }

    @Override
    public EnrollmentDto add(EnrollmentDto enrolmentDto) {
        var entity = mapper.toEntity(enrolmentDto);
        //Se obtiene el modelo del curso
        var course = addCourseToEnrollment(enrolmentDto.courseId());
        //Se agrega a la lista
        entity.getCourses().add(course);

        //Se obtiene el modelo del estudiante 
        var student = addStudentToEnrollment(enrolmentDto.studentId());
        //Se agrega a la lista
            entity.getStudents().add(student);

        var saveEntity = repository.save(entity);
        return mapper.toDto(saveEntity);
    }

    @Override
    public EnrollmentDto update(Long id, EnrollmentDto enrolmentDto) {
        getById(id);
        var entityUpdated = mapper.toEntity(enrolmentDto);
        entityUpdated.setId(id);
        
        //Se obtiene el modelo del curso
        var course = addCourseToEnrollment(enrolmentDto.courseId());
        //Se agrega a la lista
        entityUpdated.getCourses().add(course);

        //Se obtiene el modelo del estudiante 
        var student = addStudentToEnrollment(enrolmentDto.studentId());
        //Se agrega a la lista
        entityUpdated.getStudents().add(student);
        entityUpdated = repository.save(entityUpdated);
        return mapper.toDto(entityUpdated);
    }

    @Override
    public List<EnrollmentDto> getAll() {
        var listEntity = repository.findAll();
        if(listEntity.isEmpty())throw new EnrollmentNotFoundException("No hay ninguna inscripcion registrados");    
        return mapper.toDtoList(listEntity);
    }

    @Override
    public EnrollmentDto getById(Long id) {
      var entity = repository.findById(id).orElseThrow(
            () -> {throw new StudentNotFoundException("No se encuentra la inscripcion con el ID: "+ id);}
        );
    return mapper.toDto(entity);
    }

    @Override
    public EnrollmentDto delete(Long id) {
        var entity = mapper.toEntity(getById(id));
        repository.delete(entity);
        return mapper.toDto(entity);
    }

    private Course addCourseToEnrollment(Long courseId){

        var course = repositoryCourse.findById(courseId)
        .orElseThrow(
            () -> 
            new CourseNotFoundException("No se encuentra el curso con el ID: "
            + courseId));
        return course;
    }

    private Student addStudentToEnrollment(Long studentId){
        var student = repositoryStudent.findById(studentId)
        .orElseThrow(
            () -> 
            new StudentNotFoundException("No se encuentra el estudiante con el ID: "+
            studentId));
        return student;
    }
    
}
