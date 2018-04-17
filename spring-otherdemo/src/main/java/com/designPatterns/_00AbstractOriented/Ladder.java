package com.designPatterns._00AbstractOriented;

public class Ladder extends Geometry {
    private double a, b, h;

    Ladder(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }

    public double getArea() {
        return ((1 / 2.0) * (a + b) * h);
    }
}
