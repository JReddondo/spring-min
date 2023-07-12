package com.example.demo.application.pizzas.features.commands;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.Respository;
import com.example.demo.domain.ingredient.entities.Ingredient;
import com.example.demo.domain.ingredient.entities.Ingredient.IngredientId;
import com.example.demo.domain.pizza.entities.Pizza;
import com.example.demo.domain.pizza.entities.Pizza.PizzaId;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Voidy;

@Configuration
public class Create {

    @RestController
    @RequestMapping("/pizzas")
    public class Controller {

        private final Pipeline pipeline;

        public Controller(final Pipeline pipeline) {
            this.pipeline = pipeline;
        }

        @PostMapping
        public ResponseEntity<?> create(@RequestBody Request request) {
            pipeline.send(request);
            return null;
        }
    }

    public record Request(String name, Set<String> ingredients) implements Command<Voidy> {
    }

    @Component
    public class CreatePizza implements Command.Handler<Request, Voidy> {

        private final Respository.Add<Pizza> repository;
        private final Respository.Get<Ingredient, IngredientId> repositoryIngredient;

        public CreatePizza(
                final Respository.Add<Pizza> repository,
                final Respository.Get<Ingredient, IngredientId> repositoryIngredient) {
            this.repository = repository;
            this.repositoryIngredient = repositoryIngredient;
        }

        @Override
        public Voidy handle(Request record) {

            var result = record.ingredients.stream().map(i -> {
                var id = new IngredientId(i);
                return repositoryIngredient.get(id);
            });
            
            var pizza = Pizza.Create(
                    new PizzaId(UUID.randomUUID()),
                    record.name,
                    result.collect(Collectors.toSet()));

            repository.add(pizza);
            return new Voidy();
        }
    }

}
