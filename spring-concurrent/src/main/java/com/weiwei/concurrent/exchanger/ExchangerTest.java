package com.weiwei.concurrent.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerTest {

    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();

        Runnable exchangerRunnable1 = new ExchangerRunnable(exchanger, "A");
        Runnable exchangerRunnable2 = new ExchangerRunnable(exchanger, "B");

        new Thread(exchangerRunnable1).start();
        new Thread(exchangerRunnable2).start();
    }
}
