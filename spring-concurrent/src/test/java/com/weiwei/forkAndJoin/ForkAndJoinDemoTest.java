package com.weiwei.forkAndJoin;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ForkJoinPool;

/**
 * Created by weiwei on 2017/5/31.
 */
public class ForkAndJoinDemoTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ForkAndJoinDemoTest.class);

    @Test
    public void Test1() {
        ForkAndJoinDemo demo1 = new ForkAndJoinDemo(1, 50_000_000);
        ForkAndJoinDemo demo2 = new ForkAndJoinDemo(50_000_001, 100_000_000);

        demo1.fork();
        demo2.fork();

        LOGGER.info("{}", demo1.join() + demo2.join());
    }

    @Test
    public void Test2() {
        ForkJoinPool pool = new ForkJoinPool();

        ForkAndJoinDemo demo1 = new ForkAndJoinDemo(1, 25_000_000);
        ForkAndJoinDemo demo2 = new ForkAndJoinDemo(25_000_001, 50_000_000);
        ForkAndJoinDemo demo3 = new ForkAndJoinDemo(50_000_001, 75_000_000);
        ForkAndJoinDemo demo4 = new ForkAndJoinDemo(75_000_001, 100_000_000);

        LOGGER.info("{}", pool.invoke(demo1) + pool.invoke(demo2) + pool.invoke(demo3) + pool.invoke(demo4));
    }

}
