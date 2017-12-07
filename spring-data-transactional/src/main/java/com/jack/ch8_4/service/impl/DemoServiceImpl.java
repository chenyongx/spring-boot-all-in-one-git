package com.jack.ch8_4.service.impl;

import com.jack.ch8_4.domain.Person;
import com.jack.ch8_4.service.DemoService;
import com.jack.ch8_4.dao.PersonRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yangyueming
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    PersonRepository personRepository; //1

    @Override
    @Transactional(rollbackFor = {IllegalArgumentException.class}) //2
    public Person savePersonWithRollBack(Person person) {
        Person p = personRepository.save(person);

        if (StringUtils.equals(person.getName(), "汪云飞")) {
            throw new IllegalArgumentException("汪云飞已存在，数据将回滚"); //3
        }
        return p;
    }

    @Override
    @Transactional(noRollbackFor = {IllegalArgumentException.class}) //4
    public Person savePersonWithoutRollBack(Person person) {
        Person p = personRepository.save(person);
        if (StringUtils.equals(person.getName(), "汪云飞")) {
            throw new IllegalArgumentException("汪云飞虽已存在，数据将不会回滚");
        }
        return p;
    }
}
