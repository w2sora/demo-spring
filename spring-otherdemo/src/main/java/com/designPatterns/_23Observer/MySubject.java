package com.designPatterns._23Observer;

public class MySubject extends AbstractSubject {
    @Override
    public void operation() {
        System.out.println("Update my subject!");
        notifyObservers();
    }
}
