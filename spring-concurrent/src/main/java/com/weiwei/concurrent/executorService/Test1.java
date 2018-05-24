package com.weiwei.concurrent.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test1 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Asynchronous task executed.");
            }
        });

        service.shutdown();
    }
}
