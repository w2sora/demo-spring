package com.designPatterns._03Singleton;

public class Singleton2 {

    /**
     * 私有构造方法，防止被实例化
     */
    private Singleton2() {
    }

    /**
     * 使用静态内部类维护单例对象，该内部类的实例与外部类的实例没有绑定关系
     * 而且第一次被调用时（getInstance方法）才会加载，从而实现了延迟加载
     */
    private static class SingletonHolder {
        // JVM保证了静态内部类被加载的时候是线程安全的，且只被实例化一次
        // 这里的私有没有什么意义
        /* private */ static Singleton2 instance = new Singleton2();
    }

    /**
     * 获取实例
     */
    public static Singleton2 getInstance() {
        // 外围类能直接访问内部类（不管是否是静态的）的私有变量
        return SingletonHolder.instance;
    }

}
