package com.jack.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yangyueming
 */
@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);

//        ConfigurableApplicationContext context = SpringApplication.run(KafkaApplication.class, args);
//
//        KafkaSender sender = context.getBean(KafkaSender.class);
//
//        for (int i = 0; i < 3; i++) {
//            //调用消息发送类中的消息发送方法
//            sender.send();
//
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
