package com.example.demo.domain.pizza.events;


import java.util.Date;
import java.util.UUID;

import com.example.demo.common.EventBase;

public class CreateEventPizza extends EventBase<CreateEventBody> {
    public CreateEventPizza(UUID id, Date date, String type, CreateEventBody body){
        super(id,date,type,body);
    }   
}