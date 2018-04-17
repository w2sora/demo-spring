package com.designPatterns._22TemplateMethod;

public class Test {
    public static void main(String[] args) {
        AbstractCalculator calculator = new Plus();
        System.out.println(calculator.calculate("2+3", "\\+"));

        AbstractCalculator calculator2 = new Multiply();
        System.out.println(calculator2.calculate("2*3", "\\*"));
    }
}
