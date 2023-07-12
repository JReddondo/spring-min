package com.example.demo.domain.pizza.events;

import com.example.demo.domain.pizza.entities.Pizza.PizzaId;

public record UpdateEventBody(PizzaId id,String name) {
    
}
