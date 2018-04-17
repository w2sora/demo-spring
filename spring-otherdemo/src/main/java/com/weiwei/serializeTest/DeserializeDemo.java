package com.weiwei.serializeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeDemo {
    public static void main(String[] args) {
        Employee e;
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\weiwei\\Documents\\Work\\employee.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            e = (Employee) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return;
        }
        System.out.println("反序列化...");
        System.out.println("Name: " + e.getName());
        System.out.println("Address: " + e.getAddress());
        System.out.println("SSN: " + e.getSSN());
        System.out.println("Number: " + e.getNumber());
    }
}
