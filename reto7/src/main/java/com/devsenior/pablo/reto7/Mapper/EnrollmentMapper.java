package com.devsenior.pablo.reto7.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.devsenior.pablo.reto7.model.dto.EnrollmentDto;
import com.devsenior.pablo.reto7.model.entities.Enrollment;


@Mapper(componentModel="spring")
public interface EnrollmentMapper {
    


    Enrollment toEntity(EnrollmentDto enrollmentDto);

    @Mapping(target="studentId", ignore=true)
    @Mapping(target="courseId", ignore=true)
    EnrollmentDto toDto(Enrollment enrollment);

    List<EnrollmentDto> toDtoList(List<Enrollment> enrollments);
    
    
}
