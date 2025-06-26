package com.devsenior.pablo.reto7.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsenior.pablo.reto7.exception.CourseNotFoundException;
import com.devsenior.pablo.reto7.exception.EnrollmentNotFoundException;
import com.devsenior.pablo.reto7.exception.ProfessorNotFoundException;
import com.devsenior.pablo.reto7.exception.StudentNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handlerStudentNotFoundException(StudentNotFoundException ex,
            HttpServletRequest request) {
                ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.NO_CONTENT
                , ex.getMessage()
                , request.getRequestURI());

        return new ResponseEntity<>(errorResponse, HttpStatus.NO_CONTENT);
    }
    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handlerCourseNotFoundException(CourseNotFoundException ex,
            HttpServletRequest request) {
                ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.NO_CONTENT
                , ex.getMessage()
                , request.getRequestURI());

        return new ResponseEntity<>(errorResponse, HttpStatus.NO_CONTENT);
    }
    @ExceptionHandler(EnrollmentNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handlerEnrollmentNotFoundException(EnrollmentNotFoundException ex,
            HttpServletRequest request) {
                ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.NO_CONTENT
                , ex.getMessage()
                , request.getRequestURI());

        return new ResponseEntity<>(errorResponse, HttpStatus.NO_CONTENT);
    }
    @ExceptionHandler(ProfessorNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handlerProfessorNotFoundException(ProfessorNotFoundException ex,
            HttpServletRequest request) {
                ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.NO_CONTENT
                , ex.getMessage()
                , request.getRequestURI());

        return new ResponseEntity<>(errorResponse, HttpStatus.NO_CONTENT);
    }

}
