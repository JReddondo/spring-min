package com.example.demo.application.pizzas.features.eventshandlers;

import org.springframework.stereotype.Component;

import com.example.demo.domain.pizza.events.CreateEventPizza;

import an.awesome.pipelinr.Notification;

@Component
public class CreatePizzaEventHandler implements Notification.Handler<CreateEventPizza> {

    @Override
    public void handle(CreateEventPizza event) {
        
    }
    
}
