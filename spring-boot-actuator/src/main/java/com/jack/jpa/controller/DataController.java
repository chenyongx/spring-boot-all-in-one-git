package com.jack.jpa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangyueming
 */
@RestController
public class DataController {
    @RequestMapping("/")
    public String home() {
        return "hello";
    }
}
