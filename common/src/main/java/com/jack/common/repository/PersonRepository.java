package com.jack.common.repository;

import com.jack.common.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author yangyueming
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByAddress(String address);

    Person findByNameAndAddress(String name, String address);
}
