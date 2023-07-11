package com.example.demo.domain.ingredient;

import com.example.demo.domain.ingredient.entities.Ingredient;
import com.example.demo.domain.ingredient.entities.Ingredient.IngredientId;

public interface IngredientRepository {
    void add(Ingredient ingredient);
    void remove(Ingredient ingredient);
    void udpate(Ingredient ingredient);
    Ingredient add(IngredientId id);
}
