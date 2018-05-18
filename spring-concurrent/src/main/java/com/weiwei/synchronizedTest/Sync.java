package com.weiwei.synchronizedTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sync {
    private static Logger log = LoggerFactory.getLogger(Sync.class);

    // public synchronized void test() {
    public void test() {
        // synchronized (this) {
        synchronized (Sync.class) {
            log.info(">>>>>>>>>> Test 开始 >>>>>>>>>>");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            log.info("<<<<<<<<<< Test 结束 <<<<<<<<<<");
        }
    }
}
