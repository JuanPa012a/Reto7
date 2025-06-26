package com.devsenior.pablo.reto7.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.devsenior.pablo.reto7.model.dto.AuthenticationRequest;
import com.devsenior.pablo.reto7.model.entities.User;

@Mapper(componentModel = "spring")
public interface  UserMapper {
    
    @Mapping(target="roles" , ignore=true)
    @Mapping(target="professor" , ignore=true)
    @Mapping(target="student" , ignore=true)
    @Mapping(target="id" , ignore=true)
    User toEntity(AuthenticationRequest credentials);
}
