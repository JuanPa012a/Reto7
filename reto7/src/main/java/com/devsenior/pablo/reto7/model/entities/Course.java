package com.devsenior.pablo.reto7.model.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false, unique=true)
    private String code;

    @Column
    private String description;

    @Column(nullable=false)
    private Integer maxAmount;

    @ManyToOne
    @JoinColumn(name="professor_id")
    @JsonManagedReference
    private Professor professor;

    @ManyToMany(mappedBy = "courses")
    @JsonBackReference
    private List<Enrollment> enrollments;

    
   
    
}

