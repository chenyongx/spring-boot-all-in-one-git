package com.jack.mybatis.service;

import com.jack.mybatis.entity.User;

/**
 * @author yangyueming
 */
public interface UserService {

    User findById(Integer id);
}
