package com.weiwei.concurrent.forkAndJoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class MyRecursiveAction extends RecursiveAction {
    private long workLoad = 0;

    public MyRecursiveAction(long workLoad) {
        this.workLoad = workLoad;
    }

    @Override
    protected void compute() {
        if (workLoad > 16) {
            System.out.println("Splitting workLoad: " + workLoad);

            List<MyRecursiveAction> subTasks = new ArrayList<>();
            subTasks.addAll(createSubTasks());

            for (MyRecursiveAction subTask : subTasks) {
                subTask.fork();
            }
        } else {
            System.out.println("Doing workLoad myself: " + workLoad);
        }
    }

    private List<MyRecursiveAction> createSubTasks() {
        List<MyRecursiveAction> subTasks = new ArrayList<>();

        MyRecursiveAction subTask1 = new MyRecursiveAction(workLoad/2);
        MyRecursiveAction subTask2 = new MyRecursiveAction(workLoad/2);

        subTasks.add(subTask1);
        subTasks.add(subTask2);

        return subTasks;
    }
}
