package com.example.demo.application.features;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.common.Util;

@Configuration
public class Get {
    @RequestMapping("/pizzas")
    @RestController
    public class Controller {

        private final List<Response> pizzas = new ArrayList<>();

        public Controller() {
            pizzas.add(new Response("1", "carbonara"));
            pizzas.add(new Response("2", "cuatro quesos"));
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> get(@PathVariable String id) {

            var query = pizzas.stream()
                    .filter(p -> p.id.equals(id));
                    
            var pizza = Util.getEntity(query);                   

            return ResponseEntity.status(HttpStatus.OK).body(pizza);

        }

        
    }

    public record Response(String id, String name) {
    }
}
