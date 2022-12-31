package com.wlee.hoteljob.handler;


import com.wlee.hoteljob.exception.AuthException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AuthException.class)
    public ResponseEntity responseEntity() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
