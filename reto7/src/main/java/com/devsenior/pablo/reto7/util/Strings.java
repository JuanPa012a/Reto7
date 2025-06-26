package com.devsenior.pablo.reto7.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Strings {
    
    private static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public static String encodepassword(String password){
        return passwordEncoder().encode(password);
    }
}
