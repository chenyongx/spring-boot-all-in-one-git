package com.jack.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author yangyueming
 */
@SpringBootApplication
@EnableElasticsearchRepositories
public class EsLocalApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsLocalApplication.class, args);
    }
}
