package com.jack.mybatis.controller;

import com.jack.mybatis.entity.User;
import com.jack.mybatis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yangyueming
 */
@RestController
@Slf4j
public class MybatisController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/")
    public User find() {
        return userService.findById(1);
    }


    @GetMapping("/findById")
    public User findById(@RequestParam Integer id) {
        return userService.findById(id);
    }

}
