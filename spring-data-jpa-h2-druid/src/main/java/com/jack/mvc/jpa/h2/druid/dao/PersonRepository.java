package com.jack.mvc.jpa.h2.druid.dao;

import java.util.List;

import com.jack.mvc.jpa.h2.druid.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yangyueming
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByAddress(String address);

    Person findByNameAndAddress(String name, String address);
}
