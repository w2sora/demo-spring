package com.weiwei.service.impl;

import com.weiwei.dao.UserMapper;
import com.weiwei.domain.User;
import com.weiwei.service.MyBatisTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class MyBatisTestServiceImpl implements MyBatisTestService {

    private final UserMapper mapper;

    @Autowired
    public MyBatisTestServiceImpl(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public String queryPassword(String username) {
        String password = "";

        List<User> userList = mapper.selectByUsername(username);
        for (User user : userList) {
            password = user.getPassword();
        }

        return password;
    }

    @Override
    public int updateUser(User user, String username) {
        int result;

        result = mapper.updateByUsername(user, username);

        return result;
    }

    @Override
    public int deleteUser(String username) {
        int result;

        result = mapper.deleteByUsername(username);

        return result;
    }

    @Override
    public int insertUser(User user) {
        int result;

        result = mapper.insert(user);

        return result;
    }
}
