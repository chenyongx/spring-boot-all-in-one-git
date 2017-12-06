package com.jack.ch8_5.service;

import com.jack.ch8_5.domain.Person;

/**
 * @author yangyueming
 */
public interface DemoService {

    Person save(Person person);

    void remove(Long id);

    Person findOne(Person person);

}
