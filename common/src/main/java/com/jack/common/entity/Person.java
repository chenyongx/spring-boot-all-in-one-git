package com.jack.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author yangyueming
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    private Integer id;
    private String name;
    private Integer age;
    private String address;
}
