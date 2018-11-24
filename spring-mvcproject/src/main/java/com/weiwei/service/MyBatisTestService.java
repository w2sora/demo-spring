package com.weiwei.service;

import com.weiwei.domain.User;

public interface MyBatisTestService {

    String queryPassword(String username);

    int updateUser(User user, String username);

    int deleteUser(String username);

    int insertUser(User user);
}
