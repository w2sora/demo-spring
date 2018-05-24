package com.weiwei.concurrent.forkAndJoin;

import java.util.concurrent.ForkJoinPool;

public class RecursiveActionTest {
    public static void main(String[] args) {
        MyRecursiveAction action = new MyRecursiveAction(48);
        ForkJoinPool pool = new ForkJoinPool(10);
        pool.invoke(action);
    }
}
