package com.example.demo.domain.pizza;

import com.example.demo.common.Respository;
import com.example.demo.domain.pizza.entities.Pizza;
import com.example.demo.domain.pizza.entities.Pizza.PizzaId;

public interface PizzaRepository extends Respository.All<Pizza,PizzaId> {

}
