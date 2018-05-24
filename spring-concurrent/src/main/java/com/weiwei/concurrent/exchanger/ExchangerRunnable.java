package com.weiwei.concurrent.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerRunnable implements Runnable {

    private Exchanger exchanger = null;
    private Object object = null;

    public ExchangerRunnable(Exchanger exchanger, Object object) {
        this.exchanger = exchanger;
        this.object = object;
    }

    @Override
    public void run() {
        try {
            Object previous = object;
            object = exchanger.exchange(object);
            System.out.println(Thread.currentThread().getName() + " exchanged " + previous + " for " + object);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
