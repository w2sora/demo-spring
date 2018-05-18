package com.weiwei.blockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(Consumer.class);

    private BlockingQueue queue = null;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                log.info(queue.take().toString());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
