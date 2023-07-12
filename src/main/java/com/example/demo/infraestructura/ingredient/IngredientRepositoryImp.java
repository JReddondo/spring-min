package com.example.demo.infraestructura.ingredient;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.example.demo.common.Util;
import com.example.demo.domain.ingredient.IngredientRepository;
import com.example.demo.domain.ingredient.entities.Ingredient;
import com.example.demo.domain.ingredient.entities.Ingredient.IngredientId;

@Component
public class IngredientRepositoryImp implements IngredientRepository {

    private final Set<Ingredient> ingredients = new HashSet<>();
    public IngredientRepositoryImp(){
        
        
        ingredients.add(
            Ingredient.create(new IngredientId("1"), "tomate", 1D)            
        );
        ingredients.add(
            Ingredient.create(new IngredientId("2"), "queso", 5D)            
        );
        ingredients.add(
            Ingredient.create(new IngredientId("3"), "cebolla", 2D)            
        );
    }

    @Override
    public void add(Ingredient entity) {
        
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public void update(Ingredient entity) {
        
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Ingredient get(IngredientId id) {
        var result = ingredients.stream().filter(i->i.getId().equals(id));
        return Util.getEntity(result);
    }

    @Override
    public void remove(Ingredient entity) {
        
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
    
}
