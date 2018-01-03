package com.jack.jpa.asscess.web;

import com.jack.jpa.asscess.entity.Customer;
import com.jack.jpa.asscess.dao.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository repository;

    @RequestMapping("/save")
    public String home() {
        // save a couple of customers
        repository.save(new Customer("Jack", "Bauer"));
        repository.save(new Customer("Chloe", "O'Brian"));
        repository.save(new Customer("Kim", "Bauer"));
        repository.save(new Customer("David", "Palmer"));
        repository.save(new Customer("Michelle", "Dessler"));
        return "save a couple of customers";
    }

    @RequestMapping("/findAll")
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @RequestMapping("/findOne")
    public Customer findOne() {
        // fetch an individual customer by ID
        return repository.findOne(1L);
    }

    @RequestMapping("/findByLastName")
    public List<Customer> findByLastName() {
        return repository.findByLastName("Bauer");
    }
}
