package com.designPatterns._00InterfaceOriented;

public class Circle implements Geometry {
    private double r;

    Circle(double r) {
        this.r = r;
    }

    public double getArea() {
        return (3.14 * r * r);
    }
}
