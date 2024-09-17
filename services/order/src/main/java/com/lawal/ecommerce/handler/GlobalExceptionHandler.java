package com.lawal.ecommerce.handler;


import com.lawal.ecommerce.exception.BusinessException;
import com.lawal.ecommerce.exception.OrderErrorException;
import com.lawal.ecommerce.exception.CustomerNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Map<String, String>> handler(BusinessException exp)
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
//
    @ExceptionHandler(OrderErrorException.class)
    public ResponseEntity<Map<String, String>> handler(OrderErrorException exp)
    {

        var map = new HashMap<String, String>();
        map.put("Error", exp.getMessage());
        return ResponseEntity
                .status(NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(map);

    }

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




}
