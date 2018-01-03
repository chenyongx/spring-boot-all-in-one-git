package com.jack.cache.simple.web;

import com.jack.cache.simple.domain.Person;
import com.jack.cache.simple.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangyueming
 */
@RestController
public class CacheSimpleController {

    @Autowired
    DemoService demoService;

    @RequestMapping("/put")
    public Person put(Person person) {
        return demoService.save(person);
    }


    @RequestMapping("/able")
    public Person cacheable(Person person) {
        return demoService.findOne(person);
    }

    @RequestMapping("/evit")
    public String evit(Long id) {
        demoService.remove(id);
        return "ok";
    }

}
