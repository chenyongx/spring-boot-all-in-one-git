package com.jack.mongodb.controller;

import com.jack.mongodb.dao.PersonRepository;
import com.jack.mongodb.domain.Location;
import com.jack.mongodb.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yangyueming
 */
@RestController
public class DataController {

    @Autowired
    PersonRepository personRepository;

    @PostMapping("/save")
    public Person save() {
        Person p = new Person("wyf", 32);
        Set<Location> locationSet = new LinkedHashSet<>();
        Location location1 = new Location("上海", "2009");
        Location location2 = new Location("合肥", "2010");
        Location location3 = new Location("广州", "2011");
        Location location4 = new Location("马鞍山", "2012");
        locationSet.add(location1);
        locationSet.add(location2);
        locationSet.add(location3);
        locationSet.add(location4);
        p.setLocationSet(locationSet);

        return personRepository.save(p);
    }

    @PostMapping("/q1")
    public Person q1(@RequestParam String name) {
        return personRepository.findByName(name);
    }

    @RequestMapping("/q2")
    public List<Person> q2(Integer age) {
        return personRepository.withQueryFindByAge(age);
    }

}
