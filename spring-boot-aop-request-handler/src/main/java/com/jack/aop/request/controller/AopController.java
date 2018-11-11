package com.jack.aop.request.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangyueming
 */
@RestController
public class AopController {

    @RequestMapping(value = "/hello")
    public String findOne(@RequestParam String name) {
        return "hello " + name;
    }

}
