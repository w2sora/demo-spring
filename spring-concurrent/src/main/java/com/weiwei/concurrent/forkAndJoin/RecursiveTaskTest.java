package com.weiwei.concurrent.forkAndJoin;

import java.util.concurrent.ForkJoinPool;

public class RecursiveTaskTest {
    public static void main(String[] args) {
        MyRecursiveTask task = new MyRecursiveTask(48);
        ForkJoinPool pool = new ForkJoinPool(10);
        long mergedResult = pool.invoke(task);
        System.out.println("mergedResult: " + mergedResult);
    }
}
