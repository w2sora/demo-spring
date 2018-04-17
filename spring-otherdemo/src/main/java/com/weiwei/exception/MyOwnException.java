package com.weiwei.exception;

class MyOwnException extends Exception {
    MyOwnException(int n) {
        super("length: " + n + " cannot be less than zero");
    }
}
