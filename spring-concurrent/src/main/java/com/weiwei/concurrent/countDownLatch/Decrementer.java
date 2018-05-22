package com.weiwei.concurrent.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class Decrementer implements Runnable {

    private CountDownLatch latch = null;

    public Decrementer(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println("current count: " + latch.getCount());

            Thread.sleep(1000);
            latch.countDown();
            System.out.println("current count: " + latch.getCount());

            Thread.sleep(1000);
            latch.countDown();
            System.out.println("current count: " + latch.getCount());

            Thread.sleep(1000);
            latch.countDown();
            System.out.println("current count: " + latch.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
