package com.jack.thymeleaf.rediscache.dao;

import com.jack.thymeleaf.rediscache.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {


}
