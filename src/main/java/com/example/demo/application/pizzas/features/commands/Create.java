package com.example.demo.application.pizzas.features.commands;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            var response = pipeline.send(request);
            return ResponseEntity.status(201).body(response);            
        }
    }

    public record Request(String name, Set<String> ingredients) implements Command<Response> {
    }

    public record ResponseIngredient(String id,String name){}
    public record Response(UUID id,String name,Double price, Stream<ResponseIngredient> ingredients){}

    @Component
    public class CommandHandler implements Command.Handler<Request, Response> {

        private final Respository.Add<Pizza> repository;
        private final Respository.Get<Ingredient, IngredientId> repositoryIngredient;

        public CommandHandler(
                final Respository.Add<Pizza> repository,
                final Respository.Get<Ingredient, IngredientId> repositoryIngredient) {
            this.repository = repository;
            this.repositoryIngredient = repositoryIngredient;
        }

        @Override
        public Response handle(Request record) {

            var result = record.ingredients.stream().map(i -> {
                var id = new IngredientId(i);
                return repositoryIngredient.get(id);
            });
            
            var id = UUID.randomUUID();
            var pizza = Pizza.Create(
                    new PizzaId(id),
                    record.name,
                    result.collect(Collectors.toSet()));

            repository.add(pizza);
            
            return new Response(
                id, 
                pizza.getName(), 
                pizza.getPrice(), 
                pizza.getIngredients().stream().map(i->{
                    return new ResponseIngredient(i.getId().getId(), i.getName());
                }));
        }
    }

}
