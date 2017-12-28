package com.example.demo02.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @RequestMapping("/home")
    String home() {
        return "Hello World!";
    }
}
