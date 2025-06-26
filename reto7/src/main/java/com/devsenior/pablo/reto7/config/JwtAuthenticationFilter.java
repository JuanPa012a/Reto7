package com.devsenior.pablo.reto7.config;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.devsenior.pablo.reto7.util.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{

    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                log.info("Procesando petición: {} {}", request.getMethod(), request.getRequestURI());
                var authHeader = request.getHeader("Authorization");

                if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                    log.info("La peticion no tiene token o no es Bearer");
                    filterChain.doFilter(request, response);
                    return;
                }
        
                var token = authHeader.substring(7);
                log.info("El token es: {}", token);
        
                var username = jwtUtil.extractUsername(token);
                log.info("El username es: {}", username);
        
                var authentication = SecurityContextHolder.getContext().getAuthentication();
        
                if (username != null && authentication == null) {
                    log.info("Hay que cargar el usuario al contexto");
                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        
                    if (jwtUtil.validateToken(token, userDetails)) {
                        var authToken = new UsernamePasswordAuthenticationToken(userDetails, null,
                                userDetails.getAuthorities());
        
                        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authToken);
                        log.info("Usuario autenticado exitosamente: {}", username);
                    } else {
                        log.warn("Token inválido para usuario: {}", username);
                    }
                }
        
                filterChain.doFilter(request, response);
    }
}