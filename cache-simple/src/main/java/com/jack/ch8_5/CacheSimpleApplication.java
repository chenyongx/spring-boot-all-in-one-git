package com.jack.ch8_5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author yangyueming
 */
@SpringBootApplication
@EnableCaching
public class CacheSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheSimpleApplication.class, args);
    }
}
