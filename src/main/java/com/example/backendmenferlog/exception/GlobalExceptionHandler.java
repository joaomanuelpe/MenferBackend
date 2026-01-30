package com.example.backendmenferlog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiError> handleBusiness(BusinessException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ApiError(400, e.getMessage()));
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Map<String, String>> handle(ResponseStatusException ex) {
        return ResponseEntity
                .status(ex.getStatusCode())
                .contentType(MediaType.APPLICATION_JSON)
                .body(Map.of("message", ex.getReason()));
    }
}
