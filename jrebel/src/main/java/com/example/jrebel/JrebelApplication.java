package com.example.jrebel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangyueming
 */
@SpringBootApplication
@RestController
public class JrebelApplication {

    public static void main(String[] args) {
        SpringApplication.run(JrebelApplication.class, args);
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello123";
    }
}
