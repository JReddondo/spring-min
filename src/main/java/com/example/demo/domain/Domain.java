package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

public class Domain {

    public static  class Ingredient {
        public String name;
        public Double price;

        public Ingredient(String name, Double price) {
            this.name = name;
            this.price = price;
        }
    }

    public static class Pizza {
        public String name;
        private final List<Ingredient> ingredients;

        public Pizza(String name, List<Ingredient> ingredients) {
            this.name = name;
            this.ingredients = ingredients;
        }

        /*public double getPrice(){
            return this.ingredients.stream()
                .map(i->i.price)
                .reduce(0D, (a,v)->a+v) * 1.2D;
        }*/

        public double getPrice(){
            var acumulado = 0D;
            for(var ingredient:ingredients){
                acumulado+=ingredient.price;
            }
            return acumulado+1.2D;
        }
    }

    public static void run(){
        
        List<Domain.Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("queso", 10D));
        ingredients.add(new Ingredient("tomate", 1D));
        
        Pizza pizza = new Pizza("carbonara", ingredients);

        System.out.println(pizza.getPrice());
    }

}
