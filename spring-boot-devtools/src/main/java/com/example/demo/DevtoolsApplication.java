package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangyueming
 */
@SpringBootApplication
@RestController
public class DevtoolsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevtoolsApplication.class, args);
    }

    @RequestMapping("/hello")
    public String hello() {
//        Ordered.HIGHEST_PRECEDENCE;
        return "hello1234";
    }
}
