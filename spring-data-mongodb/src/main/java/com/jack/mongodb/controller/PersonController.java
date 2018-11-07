package com.jack.hbase.controller;

import com.jack.hbase.dao.PersonRepository;
import com.jack.hbase.domain.Location;
import com.jack.hbase.domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yangyueming
 */
@RestController
public class PersonController {

    @Resource
    PersonRepository personRepository;

    @PostMapping("/save")
    public Person save() {
        Person person = new Person("wyf", 32);
        Set<Location> locationSet = new LinkedHashSet<>();
        Location location1 = new Location("上海", "2009");
        Location location2 = new Location("合肥", "2010");
        Location location3 = new Location("广州", "2011");
        Location location4 = new Location("马鞍山", "2012");
        locationSet.add(location1);
        locationSet.add(location2);
        locationSet.add(location3);
        locationSet.add(location4);
        person.setLocationSet(locationSet);

        return personRepository.save(person);
    }

    @GetMapping("/findByName")
    public Person findByName(@RequestParam String name) {
        return personRepository.findByName(name);
    }

    @GetMapping("/findAll")
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @RequestMapping("/findByAge")
    public List<Person> findByAge(Integer age) {
        return personRepository.withQueryFindByAge(age);
    }

}
