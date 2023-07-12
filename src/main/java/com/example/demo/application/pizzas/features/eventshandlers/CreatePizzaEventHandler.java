package com.example.demo.application.pizzas.features.eventshandlers;

import com.example.demo.domain.pizza.events.CreateEventPizza;

import an.awesome.pipelinr.Notification;

public class CreatePizzaEventHandler implements Notification.Handler<CreateEventPizza> {

    @Override
    public void handle(CreateEventPizza event) {
        
    }
    
}
