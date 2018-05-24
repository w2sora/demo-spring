package com.weiwei.concurrent.executorService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test2 {
    public static void main(String[] args) {
        try {
            ExecutorService service = Executors.newFixedThreadPool(10);

            Future future = service.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Asynchronous task executed.");
                }
            });

            System.out.println(future.get());

            service.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
