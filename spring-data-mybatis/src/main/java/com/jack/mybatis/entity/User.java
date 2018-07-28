package com.jack.mybatis.entity;

import lombok.Data;

import java.util.Date;

/**
 * 用户信息 Created by Infi on 17/3/22.
 */
@Data
public class User {

    private Long id;
    private String userName;
    private Date birthday;
}
