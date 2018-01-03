package com.jack.transactional.web;

import com.jack.transactional.domain.Person;
import com.jack.transactional.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionalController {

    @Autowired
    DemoService demoService;

    @RequestMapping("/rollback")
    public Person rollback(Person person) { //1

        return demoService.savePersonWithRollBack(person);
    }

    @RequestMapping("/norollback")
    public Person noRollback(Person person) {//2

        return demoService.savePersonWithoutRollBack(person);


    }

}
