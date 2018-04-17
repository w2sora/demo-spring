package com.weiwei.forkAndJoin;

import java.util.concurrent.RecursiveTask;

/**
 * Created by weiwei on 2017/5/31.
 */
public class ForkAndJoinDemo extends RecursiveTask<Integer> {

    private int start;
    private int end;

    ForkAndJoinDemo(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }

}
