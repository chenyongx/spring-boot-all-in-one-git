package com.jack.ch8_5.dao;

import com.jack.ch8_5.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yangyueming
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}
