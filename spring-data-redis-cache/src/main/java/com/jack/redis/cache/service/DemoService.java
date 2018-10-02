package com.jack.redis.cache.service;

import com.jack.redis.cache.domain.Person;

/**
 * @author yangyueming
 */
public interface DemoService {

    Person save(Person person);

    void remove(Long id);

    Person findOne(Person person);

}
