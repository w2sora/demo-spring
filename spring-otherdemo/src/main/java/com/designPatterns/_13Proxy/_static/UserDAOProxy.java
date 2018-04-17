package com.designPatterns._13Proxy._static;

public class UserDAOProxy implements IUserDAO {
    private IUserDAO target;

    public UserDAOProxy(IUserDAO target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println(">>>开始事务...");
        target.save();
        System.out.println("<<<结束事务...");
    }
}
