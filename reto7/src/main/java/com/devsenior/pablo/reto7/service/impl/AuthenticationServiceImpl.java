package com.devsenior.pablo.reto7.service.impl;

import java.util.HashSet;

import org.springframework.stereotype.Service;

import com.devsenior.pablo.reto7.Mapper.UserMapper;
import com.devsenior.pablo.reto7.model.dto.AuthenticationRequest;
import com.devsenior.pablo.reto7.model.dto.AuthenticationResponse;
import com.devsenior.pablo.reto7.repository.UserRepository;
import com.devsenior.pablo.reto7.service.AuthenticationService;
import static com.devsenior.pablo.reto7.util.Strings.encodepassword;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    
    @Override
    public AuthenticationResponse login(AuthenticationRequest credentials) {
        return null;
    }

   

    @Override
    public void saveUser(AuthenticationRequest credentials, String rol) {
        var user = userMapper.toEntity(credentials);
        user.setPassword(encodepassword(user.getPassword()));
        user.setRoles(new HashSet<>());
        user.getRoles().add(rol);
        userRepository.save(user);
     }
    
}
