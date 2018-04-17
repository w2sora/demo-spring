package com.designPatterns._11Adapter._class;

public class AdapterTest {
    public static void main(String args[]) {
        Targetable target = new Adapter();
        target.method1();
        target.method2();
    }
}
