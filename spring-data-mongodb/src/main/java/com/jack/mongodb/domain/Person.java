package com.jack.mongodb.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author yangyueming
 */
@Document
@Data
public class Person {

    @Id
    private String id;
    private String name;
    private Integer age;
    private Set<Location> locationSet = new LinkedHashSet<>();

    public Person(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }
}
