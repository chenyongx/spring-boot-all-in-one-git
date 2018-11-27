package com.jack.admin.client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangyueming
 */
@RestController
public class AdminClientController {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
}
