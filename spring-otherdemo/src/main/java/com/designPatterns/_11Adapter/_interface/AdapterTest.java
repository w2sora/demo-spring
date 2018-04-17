package com.designPatterns._11Adapter._interface;

public class AdapterTest {
    public static void main(String args[]) {
        SourceSub sub = new SourceSub();
        sub.method1();
        sub.method2();
    }
}
