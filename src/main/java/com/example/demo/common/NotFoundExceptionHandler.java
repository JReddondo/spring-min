package com.example.demo.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotFoundExceptionHandler {
    
    @ExceptionHandler(value = {NotfoundException.class})
    public ResponseEntity<?> handler(NotfoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
