package com.jack.redis.dao;

import com.jack.redis.domain.Person;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class PersonDao {

    @Resource
    StringRedisTemplate stringRedisTemplate; //1

    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valOpsStr; //3


    @Resource
    RedisTemplate<Object, Object> redisTemplate; //2

    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> valOps; //4

    public void stringRedisTemplateDemo() { //5
        valOpsStr.set("xx", "yy");
    }


    public void save(Person person) { //6
        valOps.set(person.getId(), person);
    }

    public String getString() {//7
        return valOpsStr.get("xx");
    }

    public Person getPerson() {//8
        return (Person) valOps.get("1");
    }

}
