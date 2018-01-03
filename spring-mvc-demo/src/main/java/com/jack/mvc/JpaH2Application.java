package com.jack.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author yangyueming
 */
@SpringBootApplication
@EnableJpaRepositories
public class JpaH2Application {

    public static void main(String[] args) {
        SpringApplication.run(JpaH2Application.class, args);
    }
}
