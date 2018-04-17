package com.designPatterns._00AbstractOriented;

public class Circle extends Geometry {
    private double r;

    Circle(double r) {
        this.r = r;
    }

    public double getArea() {
        return (3.14 * r * r);
    }
}
