package com.jack.data.rest.simple.dao;

import com.jack.data.rest.simple.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yangyueming
 */

public interface PersonRepository extends JpaRepository<Person, Long> {

}
