package com.kz.sme_management.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler
{

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handleDataIntegrityViolation(DataIntegrityViolationException ex, WebRequest request) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", LocalDateTime.now());
        errorDetails.put("status", HttpStatus.BAD_REQUEST.value());
        errorDetails.put("error", "Data Integrity Violation");
        errorDetails.put("message", ex.getMostSpecificCause().getMessage());
        errorDetails.put("path", request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }












    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleException(MethodArgumentNotValidException ex)
    {
        Map<String, Map> response = new HashMap<>();


        Map<String, String> errors = new HashMap<>();

        String nameErrors = ex.getBindingResult()
                .getFieldErrors("name")
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(", "));

        if (!nameErrors.isEmpty()) {
            errors.put("name", nameErrors);
        }

        ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .filter(fieldError -> !fieldError.getField().equals("name"))
                .forEach(fieldError -> {
                    errors.put(fieldError.getField(), fieldError.getDefaultMessage());
                });

        response.put("fields",errors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleException(HttpMessageNotReadableException ex)
    {

        Map<String, String> response = new HashMap<>();
        response.put("error",ex.getLocalizedMessage());
        response.put("error2",ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }




}
