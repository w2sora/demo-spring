package com.weiwei.concurrent.executorService;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test4 {
    public static void main(String[] args) {
        try {
            ExecutorService service = Executors.newFixedThreadPool(10);

            Set<Callable<String>> callables = new HashSet<>();

            callables.add(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "Callable Task 1";
                }
            });
            callables.add(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "Callable Task 2";
                }
            });
            callables.add(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "Callable Task 3";
                }
            });

            String result = service.invokeAny(callables);
            System.out.println(result);

            service.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
