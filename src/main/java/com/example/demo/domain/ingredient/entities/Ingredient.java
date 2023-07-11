package com.example.demo.domain.ingredient.entities;

//entidad
public class Ingredient {
    private IngredientId id;
    private String name;
    private double price;

    protected Ingredient(IngredientId id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ingredient i) {
            return i.id.equals(this.id);
        }
        return false;
    }

    public static Ingredient create(IngredientId id, String name, double price) {
        Ingredient ingredient = new Ingredient(id, name, price);
        return ingredient;
    }

    public void update(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public IngredientId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    //value object
    public static class IngredientId {
        private String id;

        public IngredientId(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        @Override
        public int hashCode() {
            return this.id.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof IngredientId i) {
                return i.id.equals(this.id);
            }
            return false;
        }

    }

}
