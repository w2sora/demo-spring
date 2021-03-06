package web.com.weiwei.service;

import web.com.weiwei.domain.UserDO;

public interface MyBatisDemoService {

    String queryPassword(String username);

    int updateUser(UserDO user, String username);

    int deleteUser(String username);

    int insertUser(UserDO user);
}
