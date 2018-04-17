package com.designPatterns._11Adapter._object;

public class Wrapper implements Targetable {
    private Source source;

    Wrapper(Source source) {
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this id the targetable method!");
    }
}
