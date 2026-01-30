package com.example.backendmenferlog.exception;

public class BusinessException extends RuntimeException {
    public BusinessException (String message) {
        super(message);
    }
}
