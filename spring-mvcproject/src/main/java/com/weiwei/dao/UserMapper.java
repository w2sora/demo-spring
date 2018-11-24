package com.weiwei.dao;

import com.weiwei.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> selectByUsername(@Param("name") String username);

    int updateByUsername(@Param("user") User user, @Param("name") String username);

    int deleteByUsername(String username);

    int insert(User user);
}
