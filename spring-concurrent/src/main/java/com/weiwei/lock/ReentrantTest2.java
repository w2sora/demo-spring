package com.weiwei.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁测试
 */
public class ReentrantTest2 implements Runnable {
    private ReentrantLock lock = new ReentrantLock();

    private void get() {
        lock.lock();
        System.out.println(Thread.currentThread().getName());
        set();
        lock.unlock();
    }

    private void set() {
        lock.lock();
        System.out.println(Thread.currentThread().getName());
        lock.unlock();
    }

    @Override
    public void run() {
        get();
    }

    public static void main(String[] args) {
        ReentrantTest2 rt = new ReentrantTest2();
        new Thread(rt).start();
        new Thread(rt).start();
        new Thread(rt).start();
    }
}
