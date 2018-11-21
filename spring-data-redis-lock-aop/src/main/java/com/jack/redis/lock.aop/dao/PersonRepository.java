package com.jack.redis.cache.dao;

import com.jack.redis.cache.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yangyueming
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
}
