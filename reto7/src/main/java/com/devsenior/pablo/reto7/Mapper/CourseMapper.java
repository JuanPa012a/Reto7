package com.devsenior.pablo.reto7.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.devsenior.pablo.reto7.model.dto.CourseDto;
import com.devsenior.pablo.reto7.model.entities.Course;


@Mapper(componentModel="spring")
public interface CourseMapper {

    Course toEntity(CourseDto courseDto);


    @Mapping(target = "professor_id", ignore=true)
    CourseDto toDto(Course course);


    List<CourseDto> toDtoList(List<Course> courses);
    
    
}
