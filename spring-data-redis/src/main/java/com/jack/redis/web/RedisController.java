package com.jack.redis.web;

import com.jack.redis.dao.PersonDao;
import com.jack.redis.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangyueming
 */
@RestController
public class RedisController {

    @Autowired
    PersonDao personDao;

    @RequestMapping("/set") //1
    public void set() {
        Person person = new Person("1", "wyf", 32);
        personDao.save(person);
        personDao.stringRedisTemplateDemo();
    }

    @RequestMapping("/getStr") //2
    public String getStr() {
        return personDao.getString();
    }

    @RequestMapping("/getPerson") //3
    public Person getPerson() {
        return personDao.getPerson();
    }
}
