package com.jack.ch8_4.dao;

import com.jack.ch8_4.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yangyueming
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}
