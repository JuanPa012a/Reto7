package com.devsenior.pablo.reto7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsenior.pablo.reto7.model.entities.Course;

@Repository
public interface CourseRepository extends  JpaRepository<Course, Long>{
    
}
