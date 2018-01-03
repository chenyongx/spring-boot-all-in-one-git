package com.jack.mybatis.dao;

import com.jack.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;

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
