package com.example.demo.solid;

public abstract class Ave {
    private final double peso;

    protected Ave(double peso) {
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }
}
