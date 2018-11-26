package com.weiwei2.override;

public class OverrideTest {
    public static void main(String[] args) {
        T t = new B();
        t.foo();
    }
}

class T {
    T() {
        System.out.println("T()");
    }

    void foo() {
        // this代表"当前对象"
        this.bar();
    }

    void bar() {
        System.out.println("T.bar");
    }
}

class B extends T {
    B() {
        System.out.println("B()");
    }

    void foo() {
        super.foo();
    }

    void bar() {
        System.out.println("B.bar");
    }
}
