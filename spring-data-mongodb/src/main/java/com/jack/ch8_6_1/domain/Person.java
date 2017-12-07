package com.jack.ch8_6_1.domain;

import java.util.Collection;
import java.util.LinkedHashSet;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author yangyueming
 */
@Document //1
@Data
public class Person {

    @Id
    private String id;
    private String name;
    private Integer age;
    @Field("locs")
    private Collection<Location> locations = new LinkedHashSet<>();

    public Person(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }
}
