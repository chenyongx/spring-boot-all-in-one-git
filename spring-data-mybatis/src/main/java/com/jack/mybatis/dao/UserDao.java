package com.jack.mybatis.dao;

import com.jack.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author yangyueming
 */
public interface UserDao {

    /**
     * 根据用户id查询用户信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    User findById(@Param("id") Integer id);

}
