package com.designPatterns._13Proxy._static;

public class Test {
    public static void main(String[] args) {
        IUserDAO target = new UserDAO();
        IUserDAO proxy = new UserDAOProxy(target);
        proxy.save();
    }
}
