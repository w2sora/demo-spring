package com.designPatterns._34Mediator;

public class HouseRenter extends Person {

    HouseRenter(String name, Mediator mediator) {
        super(name, mediator);
    }

    /**
     * 与中介者联系
     *
     * @param message message
     */
    public void contact(String message) {
        mediator.contact(message, this);
    }

    /**
     * 获取信息
     *
     * @param message message
     */
    public void getMessage(String message) {
        System.out.println("租客: " + name + ", 获得信息: " + message);
    }
}
