package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * 用户信息dao Created by Infi on 17/3/22.
 */
public interface UserDao {

    /**
     * 根据用户id查询用户信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    User findAll(@Param("id") Integer id);

}
