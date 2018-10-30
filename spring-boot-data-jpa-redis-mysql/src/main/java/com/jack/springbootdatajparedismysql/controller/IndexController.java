package com.jack.springbootdatajparedismysql.controller;

import com.jack.springbootdatajparedismysql.entity.User;
import com.jack.springbootdatajparedismysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 19511
 */
@RestController
public class IndexController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> users() {
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }

    @GetMapping("/upuser/{id}")
    public User upuser(@PathVariable("id") Long id) {
        return userService.upuser(id);
    }

    @GetMapping("/user/{id}/{name}")
    public User update(@PathVariable("id") Long id, @PathVariable("name") String name) {
        User user = userService.findUserById(id);
        user.setUsername(name);
        userService.update(user);
        return user;
    }

}