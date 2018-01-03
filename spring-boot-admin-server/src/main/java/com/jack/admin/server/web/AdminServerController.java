package com.jack.admin.server.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminServerController {

    @RequestMapping("/home")
    String home() {
        return "Hello World!";
    }
}
