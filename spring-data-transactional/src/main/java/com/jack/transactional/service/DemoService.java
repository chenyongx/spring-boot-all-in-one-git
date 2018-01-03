package com.jack.transactional.service;

import com.jack.transactional.domain.Person;

/**
 * @author yangyueming
 */
public interface DemoService {

    Person savePersonWithRollBack(Person person);

    Person savePersonWithoutRollBack(Person person);

}
