package com.example.demo.web;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/mybatis")
@Log
public class TestController {

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
