package com.weiwei.lock;

/**
 * 可重入锁测试
 */
public class ReentrantTest1 implements Runnable {
    private synchronized void get() {
        System.out.println(Thread.currentThread().getName());
        set();
    }

    private synchronized void set() {
        System.out.println(Thread.currentThread().getName());
    }

    @Override
    public void run() {
        get();
    }

    public static void main(String[] args) {
        ReentrantTest1 rt = new ReentrantTest1();
        new Thread(rt).start();
        new Thread(rt).start();
        new Thread(rt).start();
    }
}
