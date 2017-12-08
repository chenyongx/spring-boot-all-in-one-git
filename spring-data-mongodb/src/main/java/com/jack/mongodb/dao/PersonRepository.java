package com.jack.mongodb.dao;

import com.jack.mongodb.domain.Person;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * @author yangyueming
 */
public interface PersonRepository extends MongoRepository<Person, String> {

    Person findByName(String name);

    @Query("{'age': ?0}")
    List<Person> withQueryFindByAge(Integer age);

}
