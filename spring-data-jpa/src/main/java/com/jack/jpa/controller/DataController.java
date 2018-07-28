package com.jack.jpa.controller;

import com.jack.jpa.domain.Person;
import com.jack.jpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/")
    public List<Person> home() {
        return personRepository.findAll();
    }


    /**
     * 测试findByAddress
     */
    @RequestMapping("/q1")
    public List<Person> q1(String address) {
        return personRepository.findByAddress(address);
    }

    /**
     * 测试findByNameAndAddress
     */
    @RequestMapping("/q2")
    public Person q2(String name, String address) {
        return personRepository.findByNameAndAddress(name, address);
    }


    /**
     * 测试排序
     */
    @RequestMapping("/sort")
    public List<Person> sort() {
        return personRepository.findAll(new Sort(Direction.ASC, "age"));
    }

    /**
     * 测试分页
     */
    @RequestMapping("/page")
    public Page<Person> page() {
        return personRepository.findAll(new PageRequest(1, 2));
    }
}
