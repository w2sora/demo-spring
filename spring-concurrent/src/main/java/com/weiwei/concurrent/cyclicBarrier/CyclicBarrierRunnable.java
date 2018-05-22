package com.weiwei.concurrent.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierRunnable implements Runnable {

    private CyclicBarrier barrier1 = null;
    private CyclicBarrier barrier2 = null;

    public CyclicBarrierRunnable(CyclicBarrier barrier1, CyclicBarrier barrier2) {
        this.barrier1 = barrier1;
        this.barrier2 = barrier2;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " waiting at barrier1...");
            barrier1.await();

            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " waiting at barrier2...");
            barrier2.await();

            System.out.println(Thread.currentThread().getName() + " done!");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
