package com.weiwei.concurrent.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class LatchTest {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);

        Waiter waiter = new Waiter(latch);
        Decrementer decrementer = new Decrementer(latch);

        new Thread(waiter).start();
        new Thread(decrementer).start();

    }
}
