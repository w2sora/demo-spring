package web.com.weiwei.service.impl;

import web.com.weiwei.dao.UserMapper;
import web.com.weiwei.domain.UserDO;
import web.com.weiwei.service.MyBatisDemoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class MyBatisDemoServiceImpl implements MyBatisDemoService {

    private final UserMapper mapper;

    @Autowired
    public MyBatisDemoServiceImpl(UserMapper mapper) {
        this.mapper = mapper;
    }

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
