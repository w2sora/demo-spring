package com.designPatterns._11Adapter._class;

public class Adapter extends Source implements Targetable {
    @Override
    public void method2() {
        System.out.println("this id the targetable method!");
    }
}
