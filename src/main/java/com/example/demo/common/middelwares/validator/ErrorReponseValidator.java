package com.example.demo.common.middelwares.validator;


public record ErrorReponseValidator(
    String message, 
    String field, 
    Object attemptedValue, 
    String Code
) {}


