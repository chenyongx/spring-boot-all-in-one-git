package com.jack.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author yangyueming
 */
@RestController
@RequestMapping("/kafka")
@Slf4j
public class CollectController {
    @Resource
    private KafkaTemplate kafkaTemplate;

    @GetMapping(value = "/send")
    public String sendKafka(@RequestParam String message) {
        try {
            log.info("kafka的消息={}", message);
            kafkaTemplate.send("test", "key", message);
            log.info("发送kafka成功.");
            return "发送kafka成功";
        } catch (Exception e) {
            log.error("发送kafka失败", e);
            return "发送kafka失败";
        }
    }

}