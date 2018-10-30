package com.jack.redis.cache.service.impl;

import com.jack.redis.cache.dao.PersonRepository;
import com.jack.redis.cache.domain.Person;
import com.jack.redis.cache.service.DemoService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yangyueming
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Resource
    PersonRepository personRepository;

    @Override
    @CachePut(value = "people", key = "#person.id")
    public Person save(Person person) {
        Person p = personRepository.save(person);
        System.out.println("为id、key为:" + p.getId() + "数据做了缓存");
        return p;
    }

    @Override
    @CacheEvict(value = "people")//2
    public void remove(Long id) {
        System.out.println("删除了id、key为" + id + "的数据缓存");
        //这里不做实际删除操作
    }

    @Override
    @Cacheable(value = "people", key = "#id")//3
    public Person findOne(Long id) {
        Person p = personRepository.findById(id).get();
        System.out.println("为id、key为:" + p.getId() + "数据做了缓存");
        return p;
    }

}
