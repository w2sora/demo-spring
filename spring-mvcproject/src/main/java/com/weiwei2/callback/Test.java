package com.weiwei2.callback;

public class Test {

    public static void main(String[] args) {
        Student student = new Chino();
        Teacher teacher = new Teacher(student);

        teacher.askQuestion();
    }
}
