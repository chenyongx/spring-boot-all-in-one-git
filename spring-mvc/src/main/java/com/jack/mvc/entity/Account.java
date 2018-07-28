package com.jack.mvc.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yangyueming
 */
@Data
public class Account implements Serializable {

    private static final long serialVersionUID = 5306163246780107591L;
    private Long userId;
    private String mobile;
    private String email;
    private String facebookId;
    private String weixinId;
    private String weixinName;
    private String facebookName;
    private String pwd;
    private String accessToken;
    private Date validityDate;
    private Integer clientType;
    private Integer loginType;
    private String ipAddress;
    private Date createDate;
    private Date updateDate;
    private Integer registerType;
    private Date registerDate;
    private Integer tmpType;
    private Integer activateStatus;
    private Integer registerClientType;
}
