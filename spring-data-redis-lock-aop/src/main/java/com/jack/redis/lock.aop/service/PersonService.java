package com.jack.redis.cache.service;

import com.jack.redis.cache.domain.Person;

/**
 * @author yangyueming
 */
public interface PersonService {

    Person save(Person person);

    void remove(Long id);

    Person findOne(Long id);

}
