package com.weiwei.blockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;

/**
 * Created by weiwei on 2017/5/26.
 */
public class Consumer implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    protected BlockingQueue queue = null;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            LOGGER.info(queue.take().toString());
            LOGGER.info(queue.take().toString());
            LOGGER.info(queue.take().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
