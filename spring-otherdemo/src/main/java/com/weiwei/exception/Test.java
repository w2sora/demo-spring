package com.weiwei.exception;

public class Test {
    private void function(int length) throws MyOwnException {
        if (length < 0) {
            throw new MyOwnException(length);
        } else {
            System.out.println("ok");
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        try {
            test.function(-1);
        } catch (MyOwnException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
