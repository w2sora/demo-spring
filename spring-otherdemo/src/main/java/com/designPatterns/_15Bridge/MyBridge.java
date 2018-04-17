package com.designPatterns._15Bridge;

public class MyBridge extends Bridge {
    public void method() {
        getSource().method();
    }
}
