package com.jack.cache.redis.dao;

import com.jack.cache.redis.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {


}
