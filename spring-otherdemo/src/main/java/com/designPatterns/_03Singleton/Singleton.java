package com.designPatterns._03Singleton;

public class Singleton {

    // 私有静态实例，防止被引用
    private static volatile Singleton instance = null;

    // 私有构造方法，防止被实例化
    private Singleton() {
    }

    // 双重检查锁（DCL）获取实例
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    // volatile 保证了此行代码不会被重排序，从而保证可以返回一个完整初始化的对象
                    // 即是，执行语句3时，之前的所有操作已经完成（语句3不会被重排序到语句2之前）
                    // 1. mem = allocate();         // 内存分配
                    // 2. ctorSingleton(instance);  // 初始化
                    // 3. instance = mem;           // 返回对象引用
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
