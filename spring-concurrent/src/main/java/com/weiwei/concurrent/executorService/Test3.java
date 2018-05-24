package com.weiwei.concurrent.executorService;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test3 {
    public static void main(String[] args) {
        try {
            ExecutorService service = Executors.newFixedThreadPool(10);

            Future future = service.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println("Asynchronous task executed.");
                    return "Callable Result";
                }
            });

            System.out.println(future.get());

            service.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
