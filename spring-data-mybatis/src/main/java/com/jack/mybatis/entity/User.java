package com.jack.mybatis.entity;

import lombok.Data;

import java.util.Date;


/**
 * @author yangyueming
 */
@Data
public class User {

    private Long id;
    private String userName;
    private Date birthday;
}
