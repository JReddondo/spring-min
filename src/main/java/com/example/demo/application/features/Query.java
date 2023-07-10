package com.example.demo.application.features;

import java.util.ArrayList;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Configuration
public class Query {

    @RestController
    @RequestMapping("/pizzas")
    public class Controller{
        @GetMapping
        public ResponseEntity<?> list(@RequestParam String name){
            return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<>());
        }
    }
}
