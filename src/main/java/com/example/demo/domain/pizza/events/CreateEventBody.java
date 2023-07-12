package com.example.demo.domain.pizza.events;


import java.util.Set;

import com.example.demo.domain.ingredient.entities.Ingredient;
import com.example.demo.domain.pizza.entities.Pizza.PizzaId;

public record CreateEventBody(PizzaId id,String name, Set<Ingredient> ingredients) {
    
    
}
