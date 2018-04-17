package com.weiwei.serializeTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeDemo {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.setName("weiwei");
        e.setAddress("shanghai");
        e.setSSN(123677);
        e.setNumber(100);
        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\weiwei\\Documents\\Work\\employee.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(e);
            oos.close();
            fos.close();

            System.out.println("数据被序列化进文件：employee.ser");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
