package com.example.demo.entity;

import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户信息
 * Created by Infi on 17/3/22.
 */
@Data
public class User {
    private Long id;
    private String name;
    private Date birthday;
}
