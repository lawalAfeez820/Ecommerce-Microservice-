package com.lawal.ecommerce.exception;

public class CustomerAlreadyExistException extends RuntimeException {

    public CustomerAlreadyExistException(String message) {

        super(message);
    }
}

