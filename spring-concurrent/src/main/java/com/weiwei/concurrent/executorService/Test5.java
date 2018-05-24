package com.weiwei.concurrent.executorService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test5 {
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

            List<Future<String>> futures = service.invokeAll(callables);
            for (Future<String> future : futures) {
                System.out.println(future.get());
            }

            service.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}
