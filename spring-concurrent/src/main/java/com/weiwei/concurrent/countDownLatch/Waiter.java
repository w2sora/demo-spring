package com.weiwei.concurrent.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Waiter implements Runnable {

    private CountDownLatch latch = null;

    public Waiter(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            // latch.await();
            // 毫秒 MILLISECONDS 微秒 MICROSECONDS 纳秒 NANOSECONDS
            latch.await(1500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Waiter Released.");
    }

}
