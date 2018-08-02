package com.jack.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

/**
 * @author jack
 */
@RestController
public class HelloController {

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  @GetMapping("/hello")
  void hello() {
    send();
  }

    public void send() {
        kafkaTemplate.send("test", "hello");
    }

}