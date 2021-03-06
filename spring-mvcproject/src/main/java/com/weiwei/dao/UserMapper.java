package com.weiwei.dao;

import com.weiwei.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserDO> selectByUsername(@Param("name") String username);

    int updateByUsername(@Param("user") UserDO user, @Param("name") String username);

    int deleteByUsername(String username);

    int insert(UserDO user);
}
