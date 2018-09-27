package com.jack.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jack
 */
@RestController
public class HelloController {

  @Resource
  private KafkaTemplate<String, String> kafkaTemplate;

  @GetMapping("/hello")
  void hello() {
    send();
  }

    public void send() {
        kafkaTemplate.send("test", "hello");
    }

}