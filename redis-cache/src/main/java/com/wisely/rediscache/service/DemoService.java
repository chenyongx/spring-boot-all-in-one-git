package com.wisely.rediscache.service;

import com.wisely.rediscache.domain.Person;

/**
 * @author yangyueming
 */
public interface DemoService {

    Person save(Person person);

    void remove(Long id);

    Person findOne(Person person);

}
