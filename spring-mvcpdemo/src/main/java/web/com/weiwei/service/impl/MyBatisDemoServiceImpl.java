package web.com.weiwei.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.com.weiwei.dao.UserMapper;
import web.com.weiwei.domain.UserDO;
import web.com.weiwei.service.MyBatisDemoService;

import java.util.List;

@Transactional
@Service
public class MyBatisDemoServiceImpl implements MyBatisDemoService {

    private static final String CACHE_NAME = "password";

    private final UserMapper mapper;

    @Autowired
    public MyBatisDemoServiceImpl(UserMapper mapper) {
        this.mapper = mapper;
    }

    // @Cacheable(value = CACHE_NAME, key = "#root.args")
    @Cacheable(value = CACHE_NAME, key = "#username")
    @Override
    public String queryPassword(String username) {
        String password = StringUtils.EMPTY;

        List<UserDO> userList = mapper.selectByUsername(username);
        for (UserDO user : userList) {
            password = user.getPassword();
        }

        return password;
    }

    @Override
    public int updateUser(UserDO user, String username) {
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
    public int insertUser(UserDO user) {
        int result;

        result = mapper.insert(user);

        return result;
    }
}
