package com.designPatterns._25ChainOfResp;

public class MyHandler extends AbstractHandler implements Handler {
    private String name;

    public MyHandler(String name) {
        this.name = name;
    }

    @Override
    public void operator() {
        System.out.println(name + " done!");
        if (getHandler() != null) {
            getHandler().operator();
        }
    }
}
