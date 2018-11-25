package com.weiwei.service;

import com.weiwei.domain.UserDO;

public interface MyBatisTestService {

    String queryPassword(String username);

    int updateUser(UserDO user, String username);

    int deleteUser(String username);

    int insertUser(UserDO user);
}
