package com.jack.mybatis.mapper;


import com.jack.mybatis.entity.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from user where id=#{0}")
    User getById(Integer id);
}