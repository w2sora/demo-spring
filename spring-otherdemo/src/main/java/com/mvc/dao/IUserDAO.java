package com.mvc.dao;

import com.mvc.vo.User;

public interface IUserDAO {
    boolean findLogin(User user) throws Exception;
}
