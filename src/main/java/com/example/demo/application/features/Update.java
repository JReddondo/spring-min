package com.example.demo.application.features;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
public class Update {

    @RestController
    @RequestMapping("/pizzas")
    public class Controller{

        @PutMapping(path="/{id}")
        public ResponseEntity<?> update(@PathVariable String id, @RequestBody Request request){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }

    }
    public record Request(String id, String name) {
    }
}
