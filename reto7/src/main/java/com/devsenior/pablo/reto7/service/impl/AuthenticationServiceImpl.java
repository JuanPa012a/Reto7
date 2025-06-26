package com.devsenior.pablo.reto7.service.impl;

import java.util.HashSet;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.devsenior.pablo.reto7.Mapper.UserMapper;
import com.devsenior.pablo.reto7.model.dto.AuthenticationRequest;
import com.devsenior.pablo.reto7.model.dto.AuthenticationResponse;
import com.devsenior.pablo.reto7.repository.UserRepository;
import com.devsenior.pablo.reto7.service.AuthenticationService;
import com.devsenior.pablo.reto7.util.JwtUtil;
import static com.devsenior.pablo.reto7.util.Strings.encodepassword;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    private final CustomUserDetailsService userDetailsService;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtuUtil;
    private final UserRepository userRepository;
    
    @Override
    public AuthenticationResponse login(AuthenticationRequest credentials) {
            authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword())
        );
        var userDetails = userDetailsService.loadUserByUsername(credentials.getUsername());
        
        final String jwt = jwtuUtil.generateToken(userDetails); 
        return new AuthenticationResponse(jwt);
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
