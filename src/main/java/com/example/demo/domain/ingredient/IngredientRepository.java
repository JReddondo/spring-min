package com.example.demo.domain.ingredient;


import com.example.demo.common.Respository;
import com.example.demo.domain.ingredient.entities.Ingredient;
import com.example.demo.domain.ingredient.entities.Ingredient.IngredientId;

public interface IngredientRepository extends Respository.All<Ingredient,IngredientId> {
    
}
