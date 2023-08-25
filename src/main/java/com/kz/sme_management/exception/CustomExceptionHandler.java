package com.kz.sme_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler
{

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
