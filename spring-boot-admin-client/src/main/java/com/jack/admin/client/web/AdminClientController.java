package com.jack.admin.client.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminClientController {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
}
