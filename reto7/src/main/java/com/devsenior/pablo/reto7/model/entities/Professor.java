package com.devsenior.pablo.reto7.model.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "professor")
public class Professor  {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String firstName;

    @Column(nullable=false)
    private String lastName;

    @Column(nullable=false)
    private String departament;

    @Column(nullable=false, unique=true)
    private String email;

    @OneToMany(mappedBy="professor", fetch=FetchType.LAZY)
    private List<Course> courses;

    @OneToOne
    @JoinColumn(name="user_id", unique=true)
    private User user;

    
    
    

    
}
