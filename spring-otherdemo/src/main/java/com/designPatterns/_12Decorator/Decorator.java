package com.designPatterns._12Decorator;

public class Decorator implements Sourceable {
    private Sourceable source;

    Decorator(Sourceable source) {
        this.source = source;
    }

    @Override
    public void method() {
        System.out.println("before decorator!");
        source.method();
        System.out.println("after decorator!");
    }
}
