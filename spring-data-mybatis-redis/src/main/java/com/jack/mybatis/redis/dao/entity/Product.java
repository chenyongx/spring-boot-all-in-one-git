package com.jack.mybatis.redis.dao.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yangyueming
 */
@Data
public class Product implements Serializable {
    private static final long serialVersionUID = 1435515995276255188L;

    private long id;
    private String name;
    private long price;
}
