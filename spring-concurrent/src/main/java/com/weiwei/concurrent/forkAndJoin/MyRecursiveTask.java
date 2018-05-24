package com.weiwei.concurrent.forkAndJoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Long> {
    private long workLoad = 0;

    public MyRecursiveTask(long workLoad) {
        this.workLoad = workLoad;
    }

    @Override
    protected Long compute() {
        if (workLoad > 16) {
            System.out.println("Splitting workLoad: " + workLoad);

            List<MyRecursiveTask> subTasks = new ArrayList<>();
            subTasks.addAll(createSubTasks());

            for (MyRecursiveTask subTask : subTasks) {
                subTask.fork();
            }

            long result = 0;
            for (MyRecursiveTask subTask : subTasks) {
                result += subTask.join();
            }

            return result;
        } else {
            System.out.println("Doing workLoad myself: " + workLoad);
            return workLoad*3;
        }
    }

    private List<MyRecursiveTask> createSubTasks() {
        List<MyRecursiveTask> subTasks = new ArrayList<>();

        MyRecursiveTask subTask1 = new MyRecursiveTask(workLoad/2);
        MyRecursiveTask subTask2 = new MyRecursiveTask(workLoad/2);

        subTasks.add(subTask1);
        subTasks.add(subTask2);

        return subTasks;
    }
}
