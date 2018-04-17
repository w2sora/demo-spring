package com.designPatterns._12Decorator;

public class DecoratorTest {
    public static void main(String args[]) {
        Sourceable s1 = new Source();
        Sourceable s2 = new Decorator(s1);
        s2.method();
    }
}
