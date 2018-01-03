package com.jack.mybatis.service.impl;

import com.jack.mybatis.dao.UserDao;
import com.jack.mybatis.entity.User;
import com.jack.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yangyueming
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findAll(Integer id) {
        return userDao.findAll(id);
    }

}
