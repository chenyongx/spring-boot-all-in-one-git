package com.jack.activemq;

import com.jack.activemq.service.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

/**
 * @author yangyueming
 */
@SpringBootApplication
@EnableJms
public class ActivemqApplication implements CommandLineRunner { //1

    @Autowired
    JmsTemplate jmsTemplate; //2

    public static void main(String[] args) {
        SpringApplication.run(ActivemqApplication.class, args);
    }

    @Override
    public void run(String... args) {
        jmsTemplate.send("my-destination", new Msg()); //3
    }
}
