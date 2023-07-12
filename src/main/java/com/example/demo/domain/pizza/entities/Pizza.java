package com.example.demo.domain.pizza.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.example.demo.common.Agregate;
import com.example.demo.domain.ingredient.entities.Ingredient;
import com.example.demo.domain.pizza.domainexception.RemoveIngredientException;
import com.example.demo.domain.pizza.events.UpdateEventBody;
import com.example.demo.domain.pizza.events.UpdateEventPizza;

public class Pizza extends Agregate {

    private final PizzaId id;
    private String name;
    private Set<Ingredient> ingredients = new HashSet<>();

    public PizzaId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients.stream().toList();
    }

    public double getPrice() {
        return ingredients.stream()
                .map(i -> i.getPrice())
                .reduce(0D, (a, v) -> a + v) * 1.2D;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pizza p) {
            return p.getId().equals(this.id);
        }
        return false;
    }

    protected Pizza(PizzaId id, String name, Set<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
    }

    public static Pizza Create(PizzaId id, String name, Set<Ingredient> ingredients) {
        var pizza = new Pizza(id, name, ingredients);
        return pizza;
    }

    public void update(String name) {
        this.name = name;

        var event = new UpdateEventPizza(
                UUID.randomUUID(),
                new Date(),
                "Update-Pizza",
                new UpdateEventBody(id, name));
        addEvent(event);
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient) {
        if (!ingredients.contains(ingredient)) {
            throw new RemoveIngredientException(1527, "el ingrediente no existe en la pizza");
        }
        ingredients.remove(ingredient);
    }

    public static class PizzaId {
        private final UUID id;

        public PizzaId(UUID id) {
            this.id = id;
        }

        public UUID getId() {
            return id;
        }

        @Override
        public int hashCode() {
            return this.id.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof PizzaId p) {
                return this.id.equals(p.getId());
            }
            return false;
        }

    }
}
