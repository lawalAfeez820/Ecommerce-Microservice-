package com.lawal.ecommerce.handler;


import com.lawal.ecommerce.exception.CustomerAlreadyExistException;
import com.lawal.ecommerce.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Map<String, String>> handler(CustomerNotFoundException exp)
    {

        var map = new HashMap<String, String>();
        map.put("Error", exp.getMessage());
        return ResponseEntity
                .status(NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(map);

    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleException(MethodArgumentNotValidException exp){

        Set<String> errors = new HashSet<>();
        exp.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var errorMessage = error.getDefaultMessage();
                    errors.add(errorMessage);
                });
        return ResponseEntity.status(BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(
                ErrorResponse.builder()
                        .error(errors)
                        .build()
        );


    }

    @ExceptionHandler(CustomerAlreadyExistException.class)
    public ResponseEntity<Map<String, String>> handler(CustomerAlreadyExistException exp)
    {

        var map = new HashMap<String, String>();
        map.put("Error", exp.getMessage());
        return ResponseEntity
                .status(CONFLICT)
                .contentType(MediaType.APPLICATION_JSON)
                .body(map);

    }


}
