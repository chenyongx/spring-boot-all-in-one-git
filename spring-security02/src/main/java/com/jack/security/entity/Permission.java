package com.jack.security.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Permission {
    private Integer id;
    private String name;
    private String permissionUrl;
    private String method;
    private String description;
}