package com.example.demo.domain.pizza;

import com.example.demo.domain.pizza.entities.Pizza;
import com.example.demo.domain.pizza.entities.Pizza.PizzaId;

public interface PizzaRepository {
    void add(Pizza pizza);
    void update(Pizza pizza);
    void remove(Pizza pizza);
    Pizza get(PizzaId id);
    
}
