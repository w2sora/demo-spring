package com.designPatterns._13Proxy._dynamic;

public class UserDAO implements IUserDAO {
    @Override
    public void save() {
        System.out.println("已经保存数据！");
    }
}
