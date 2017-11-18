package com.example.demo.entity;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author yym
 * @date 17/3/22
 */
@Data
public class User {

    private Long id;
    private String userName;
    private Date birthday;
}
