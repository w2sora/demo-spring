package com.weiwei2.callback;

public class Chino implements Student {
    @Override
    public void resolveQuestion(Callback callback, String question) {
        System.out.println("智乃收到问题：" + question);

        try {
            System.out.println("智乃计算中...");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        callback.solve("1+1=2");
    }
}
