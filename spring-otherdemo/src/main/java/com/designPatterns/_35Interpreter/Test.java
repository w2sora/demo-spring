package com.designPatterns._35Interpreter;

public class Test {

    public static void main(String[] args) {
        // 计算 9+2-8 的值
        int result = new Minus().interpret(
                new Context(new Plus().interpret(new Context(9, 2)), 8));
        System.out.println(result);
    }
}
