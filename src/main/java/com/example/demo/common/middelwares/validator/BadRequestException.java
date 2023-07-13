package com.example.demo.common.middelwares.validator;

import java.util.List;

public class BadRequestException extends RuntimeException{

   
    private final List<ErrorReponseValidator> errors;

    public BadRequestException(List<ErrorReponseValidator> errors){
        this.errors = errors;
    }
    public List<ErrorReponseValidator> getErrors(){
        return errors;
    }

}
