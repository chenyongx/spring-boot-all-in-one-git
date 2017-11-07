package com.jack.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 使用Eureka做服务发现.
 * @author yangyueming
 */
@SpringBootApplication
@EnableEurekaServer
public class Eureka2Application {
  public static void main(String[] args) {
    SpringApplication.run(Eureka2Application.class, args);
  }
}
