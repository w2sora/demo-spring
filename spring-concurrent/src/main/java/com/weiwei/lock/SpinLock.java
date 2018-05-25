package com.weiwei.lock;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 自旋锁
 *
 * <h3>关于自旋锁和阻塞锁的说明</h3>
 *
 * <p>自旋锁不进行线程状态的改变，所以响应速度更快，但当线程数不停增加时，
 * <p>性能下降明显，因为每个线程都需要执行，占用CPU时间。在理想的情况下：
 * <ul>
 * <li>在线程竞争不激烈的情况下，建议使用<b>自旋锁</b>
 * <li>在线程竞争激烈的情况下，建议使用<b>阻塞锁</b>（如 synchronized 和 {@link ReentrantLock} 等）
 * </ul>
 *
 * @see ReentrantLock
 */
public class SpinLock {
    private AtomicReference<Thread> owner = new AtomicReference<>();

    public void lock() {
        Thread current = Thread.currentThread();
        while (!owner.compareAndSet(null, current)) {
            // 如果有其他线程已获得锁，这里会一直循环，直到其他线程释放锁为止，故称为自旋锁
        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        owner.compareAndSet(current, null);
    }
}
