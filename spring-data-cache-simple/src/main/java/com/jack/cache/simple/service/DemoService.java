package com.jack.cache.simple.service;

import com.jack.cache.simple.domain.Person;

/**
 * @author yangyueming
 */
public interface DemoService {

    Person save(Person person);

    void remove(Long id);

    Person findOne(Person person);

}
