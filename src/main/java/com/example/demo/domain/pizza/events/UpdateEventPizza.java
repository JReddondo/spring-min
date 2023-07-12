package com.example.demo.domain.pizza.events;


import java.util.Date;
import java.util.UUID;

import com.example.demo.common.EventBase;

public class UpdateEventPizza extends EventBase<UpdateEventBody> {
    public UpdateEventPizza(UUID id, Date date, String type, UpdateEventBody body){
        super(id,date,type,body);
    }   
}
