package com.devsenior.pablo.reto7.service;

import java.util.List;

import com.devsenior.pablo.reto7.model.dto.CourseDto;


public interface ServiceCourse {
    
    CourseDto add(CourseDto studentDto);

    CourseDto update(Long id, CourseDto studentDto);

    List<CourseDto> getAll();
    
    CourseDto getById(Long id);

    CourseDto delete(Long id);

}
