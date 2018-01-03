package com.jack.mybatis.entity;

import java.util.Date;
import lombok.Data;

/**
 * 用户信息 Created by Infi on 17/3/22.
 */
@Data
public class User {

    private Long id;
    private String userName;
    private Date birthday;
}
