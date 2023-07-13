package com.example.demo.common.middelwares.validator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BadRequestHandlerException {

    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<?> handler(BadRequestException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
    }

}
