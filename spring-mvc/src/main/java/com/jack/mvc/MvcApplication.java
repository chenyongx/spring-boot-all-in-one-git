package com.jack.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author yangyueming
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@EnableJpaRepositories
@EnableJpaRepositories(basePackages={"com.jack.mvc"})
@EnableScheduling
@EnableAsync
public class MvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvcApplication.class, args);

//        SpringApplication app = new SpringApplication(MvcApplication.class);
//        app.setBannerMode(Banner.Mode.OFF);
//        app.run(args);

//        new SpringApplicationBuilder()
//                .child(MvcApplication.class)
//                .bannerMode(Banner.Mode.OFF)
//                .run(args);
    }

}
