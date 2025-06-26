package com.devsenior.pablo.reto7.Mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.devsenior.pablo.reto7.model.dto.StudentDto;
import com.devsenior.pablo.reto7.model.entities.Student;

@Mapper(componentModel="spring")
public interface StudentMapper {
    


    Student toEntity(StudentDto studentDto);

    StudentDto toDto(Student student);

    List<StudentDto> toDtoList(List<Student> students);
    
    
}
