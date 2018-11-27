package com.jack.admin.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangyueming
 */
@RestController
public class AdminServerController {

    @RequestMapping("/home")
    String home() {
        return "Hello World!";
    }
}
