package com.weiwei.synchronizedTest;

public class MyThread extends Thread {
    public void run() {
        Sync sync = new Sync();
        sync.test();
    }
}
