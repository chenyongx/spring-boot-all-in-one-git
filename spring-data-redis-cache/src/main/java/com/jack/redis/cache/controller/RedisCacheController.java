package com.jack.redis.cache.controller;

import com.jack.redis.cache.domain.Person;
import com.jack.redis.cache.service.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yangyueming
 */
@RestController
public class RedisCacheController {
    @Resource
    DemoService demoService;

    @RequestMapping(value = "/findOne" , produces="application/json;charset=UTF-8")
    public Person findOne(Long id) {
        return demoService.findOne(id);
    }

    @RequestMapping("/evict")
    public String evict(Long id) {
        demoService.remove(id);
        return "ok";
    }

    @RequestMapping("/put")
    public Person put(Person person) {
        return demoService.save(person);
    }
}
