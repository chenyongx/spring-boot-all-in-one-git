package com.jack.global.exception.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangyueming
 */
@RestController
public class ErrorController {

    @RequestMapping(value = "/hello")
    public String findOne(@RequestParam Integer i) {
        return String.valueOf(1/i);
    }

}
