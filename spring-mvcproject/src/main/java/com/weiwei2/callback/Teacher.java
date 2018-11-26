package com.weiwei2.callback;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 异步回调的例子
 * 如果使用同步回调，直接在askQuestion中调用Student的resolveQuestion方法即可
 */
public class Teacher implements Callback {

    private static final String QUESTION = "1+1=?";
    private Student student;

    public Teacher(Student student) {
        this.student = student;
    }

    public void askQuestion() {
        System.out.println("老师提问：" + QUESTION);

        ExecutorService service = Executors.newFixedThreadPool(5);
        service.execute(() -> student.resolveQuestion(Teacher.this, QUESTION));

        // ExecutorService不会再接收新的任务，但是会等待已经提交的任务完成，再进行关闭
        service.shutdown();
        // service.shutdownNow();

        System.out.println("老师干别的事去了");
    }

    // 回调方法
    @Override
    public void solve(String answer) {
        System.out.println("老师收到答案：" + answer);
    }
}
