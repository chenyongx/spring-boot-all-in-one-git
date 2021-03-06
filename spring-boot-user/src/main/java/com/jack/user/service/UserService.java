package com.jack.user.service;

import com.jack.user.entity.User;
import com.jack.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean verifyUser(User user) {

        if (userRepository.findByNameAndPassword(user.getName(), user.getPassword()).isEmpty()) {
            return false;
        } else {
            return true;
        }

    }

    public String registerUser(User user) {

        if (userRepository.findByName(user.getName()).isEmpty()) {
            userRepository.save(user);
            return "用户名  " + user.getName() + " 注册成功";

        } else {

            return "用户名 " + user.getName() + "已被占用！";
        }

    }
}