package com.jack.springbootdatajparedismysql.service;

import com.jack.springbootdatajparedismysql.entity.User;

import java.util.List;

/**
 * @author 19511
 */
public interface UserService {

    List<User> findAll();

    User findUserById(Long id);

    void update(User user);

    void remove(Long id);

    User upuser(Long id);

}