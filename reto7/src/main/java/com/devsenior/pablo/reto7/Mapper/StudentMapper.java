package com.devsenior.pablo.reto7.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.devsenior.pablo.reto7.model.dto.StudentDto;
import com.devsenior.pablo.reto7.model.entities.Student;

@Mapper(componentModel="spring")
public interface StudentMapper {
    
    StudentMapper INSTANCE = (StudentMapper) Mappers.getMapper(Student.class);

    Student toEntity(StudentDto studentDto);

    StudentDto toDto(Student student);

    List<StudentDto> toDtoList(List<Student> students);
    
    
}
