package com.jack.mvc.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author jack
 */
@Data
@Entity
public class User {
    @Id
    private Integer userId;
    private String username;
    private String password;
}
