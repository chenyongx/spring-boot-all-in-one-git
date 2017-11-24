package com.wisely.rediscache.dao;

import com.wisely.rediscache.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {


}
