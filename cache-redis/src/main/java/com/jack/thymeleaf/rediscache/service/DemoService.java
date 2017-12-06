package com.jack.thymeleaf.rediscache.service;

import com.jack.thymeleaf.rediscache.domain.Person;

/**
 * @author yangyueming
 */
public interface DemoService {

    Person save(Person person);

    void remove(Long id);

    Person findOne(Person person);

}
