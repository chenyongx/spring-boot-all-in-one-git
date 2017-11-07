package com.example.demo.mapper;


import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from user where id=#{0}")
    User getById(Integer id);
}