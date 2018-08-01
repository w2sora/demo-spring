package com.weiwei.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class reflectTest {

    public static Car initByDefaultConst() throws Throwable {
        // 通过类装载器获取Car类对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.weiwei.reflect.Car");

        // 构造方法的形参类型数组
        Class[] parameterTypes = new Class[0];
        // 获取类的默认构造方法对象并通过它实例化Car
        Constructor cons = clazz.getDeclaredConstructor(parameterTypes);
        Car car = (Car) cons.newInstance();

        // 通过反射方法设置属性
        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car, "RR");
        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car, "Black");
        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car, 200);

        return car;
    }

    public static void main(String[] args) throws Throwable {
        Car car = initByDefaultConst();
        car.introduce();
    }
}
