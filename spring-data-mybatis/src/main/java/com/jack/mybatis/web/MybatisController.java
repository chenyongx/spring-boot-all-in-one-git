package com.jack.mybatis.web;

import com.jack.mybatis.entity.User;
import com.jack.mybatis.service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/mybatis")
@Log
public class MybatisController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public User find() {
        return userService.findAll(1);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id) {
        return userService.findAll(id);
    }


}
