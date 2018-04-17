package com.weiwei.weakReference;

import java.lang.ref.WeakReference;

public class Test {

    public static void main(String[] args) {
        Car car = new Car(200000, "black");
        WeakReference<Car> wrc = new WeakReference<>(car);

        int i = 0;
        while (true) {
            // System.out.println("here is the strong reference 'car' " + car);
            if (wrc.get() != null) {
                i++;
                System.out.println("WeakReferenceCar's Car is alive for " + i + ", loop - " + wrc);
            } else {
                System.out.println("WeakReferenceCar's Car has bean collected");
                break;
            }
        }

    }
}
