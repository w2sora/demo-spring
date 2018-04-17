package com.designPatterns._00InterfaceOriented;

public class Pillar {
    private Geometry bottom;
    private double height;

    Pillar(Geometry bottom, double height) {
        this.bottom = bottom;
        this.height = height;
    }

    public void changeBottom(Geometry bottom) {
        this.bottom = bottom;
    }

    public double getVolume() {
        return bottom.getArea() * height;
    }
}
