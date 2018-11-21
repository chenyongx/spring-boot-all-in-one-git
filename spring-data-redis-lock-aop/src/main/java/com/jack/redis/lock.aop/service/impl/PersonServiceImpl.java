package com.jack.redis.cache.service.impl;

import com.jack.redis.cache.dao.PersonRepository;
import com.jack.redis.cache.domain.Person;
import com.jack.redis.cache.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yangyueming
 */
@Service
@Slf4j
public class PersonServiceImpl implements PersonService {
    private static final String CACHE_VALUE ="people";

    @Resource
    PersonRepository personRepository;

    @Override
    @CachePut(value = CACHE_VALUE, key = "'people_'.concat(#person.id)")
    public Person save(Person person) {
        Person p = personRepository.save(person);
        log.info("为id、key为:" + p.getId() + "数据做了缓存");
        return p;
    }

    @Override
    @CacheEvict(value = CACHE_VALUE, key = "'people_'.concat(#id)")//2
    public void remove(Long id) {
        log.info("删除了id、key为" + id + "的数据缓存");
        //这里不做实际删除操作
    }

    @Override
    @CachePut(value = CACHE_VALUE, key = "'people_'.concat(#id)")
    public Person findOne(Long id) {
        Person p = personRepository.findById(id).get();
        log.info("为id、key为:" + p.getId() + "数据做了缓存");
        return p;
    }

}
