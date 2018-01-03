package com.jack.transactional.dao;

import com.jack.transactional.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yangyueming
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}
