package com.jack.redis.cache.controller;

import com.jack.redis.cache.domain.Person;
import com.jack.redis.cache.service.PersonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yangyueming
 */
@RestController
public class RedisCacheController {
    @Resource
    PersonService personService;

    @RequestMapping(value = "/findOne" , produces="application/json;charset=UTF-8")
    public Person findOne(Long id) {
        return personService.findOne(id);
    }

    @RequestMapping("/evict")
    public String evict(Long id) {
        personService.remove(id);
        return "ok";
    }

    @RequestMapping("/put")
    public Person put(Person person) {
        return personService.save(person);
    }
}
