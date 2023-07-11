package com.example.demo.domain.pizza.domainexception;

import com.example.demo.common.DomainException;

public class RemoveIngredientException extends DomainException {
     public RemoveIngredientException(int code,String message){
        super(code,message);
     }   
}
