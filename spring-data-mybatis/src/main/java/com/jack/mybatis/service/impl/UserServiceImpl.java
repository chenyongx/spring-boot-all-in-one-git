package com.jack.mybatis.service.impl;

import com.jack.mybatis.dao.UserDao;
import com.jack.mybatis.entity.User;
import com.jack.mybatis.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yangyueming
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

}
