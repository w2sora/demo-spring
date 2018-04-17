package com.designPatterns._21Strategy;

public class StrategyTest {
    public static void main(String[] args) {
        ICalculator calculator = new Multiply();
        System.out.println(calculator.calculate("2*3"));
    }
}
