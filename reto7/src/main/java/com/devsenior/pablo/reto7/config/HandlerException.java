package com.devsenior.pablo.reto7.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsenior.pablo.reto7.exception.CourseNotFoundException;
import com.devsenior.pablo.reto7.exception.EnrollmentNotFoundException;
import com.devsenior.pablo.reto7.exception.ProfessorNotFoundException;
import com.devsenior.pablo.reto7.exception.StatusNotFoundException;
import com.devsenior.pablo.reto7.exception.StudentNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handlerStudentNotFoundException(StudentNotFoundException ex,
            HttpServletRequest request) {
                ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.NOT_FOUND
                , ex.getMessage()
                , request.getRequestURI());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handlerCourseNotFoundException(CourseNotFoundException ex,
            HttpServletRequest request) {
                ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.NOT_FOUND
                , ex.getMessage()
                , request.getRequestURI());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EnrollmentNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handlerEnrollmentNotFoundException(EnrollmentNotFoundException ex,
            HttpServletRequest request) {
                ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.NOT_FOUND
                , ex.getMessage()
                , request.getRequestURI());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ProfessorNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handlerProfessorNotFoundException(ProfessorNotFoundException ex,
            HttpServletRequest request) {
                ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.NOT_FOUND
                , ex.getMessage()
                , request.getRequestURI());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuthorizationDeniedException.class)
    public ResponseEntity<ApiErrorResponse> handlerAuthorizationDeniedException(AuthorizationDeniedException ex,
            HttpServletRequest request) {
                ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.FORBIDDEN
                , ex.getMessage()
                , request.getRequestURI());

        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(StatusNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handlerStatusNotFoundException(StatusNotFoundException ex,
            HttpServletRequest request) {
                ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.CONFLICT
                , ex.getMessage()
                , request.getRequestURI());

        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiErrorResponse> handlerRuntimeException(RuntimeException ex,
            HttpServletRequest request) {
                ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR
                , ex.getMessage()
                , request.getRequestURI());

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handlerException(Exception ex,
            HttpServletRequest request) {
                ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR
                , ex.getMessage()
                , request.getRequestURI());

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
