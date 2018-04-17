package com.designPatterns._11Adapter._interface;

public class SourceSub extends Wrapper {
    @Override
    public void method2() {
        System.out.println("I only implement the method 2!");
    }
}
