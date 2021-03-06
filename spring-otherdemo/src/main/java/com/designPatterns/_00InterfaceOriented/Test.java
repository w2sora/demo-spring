package com.designPatterns._00InterfaceOriented;

public class Test {

    public static void main(String[] args) {
        Pillar pillar;
        Geometry geometry;

        geometry = new Ladder(12, 22, 100);
        System.out.println("梯形的面积: " + geometry.getArea());
        pillar = new Pillar(geometry, 58);
        System.out.println("柱体的体积: " + pillar.getVolume());

        geometry = new Circle(10);
        System.out.println("圆形的面积: " + geometry.getArea());
        pillar.changeBottom(geometry);
        System.out.println("柱体的体积: " + pillar.getVolume());
    }
}
