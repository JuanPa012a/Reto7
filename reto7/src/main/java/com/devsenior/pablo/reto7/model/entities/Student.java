package com.devsenior.pablo.reto7.model.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String firstName;

    @Column(nullable=false)
    private String lastName;
  
    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false, unique=true)
    private String phone;

    @ManyToMany(mappedBy = "students")
    private List<Enrollment> enrollments;
    
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
  
    
}
