package com.example.demo.solid;

public abstract class AveVoladora extends Ave {
    private final double velocidad;

    protected AveVoladora(double velocidad, double peso) {
        super(peso);
        this.velocidad = velocidad;
    }

    public double getVelocidad() {
        return velocidad;
    }

}
