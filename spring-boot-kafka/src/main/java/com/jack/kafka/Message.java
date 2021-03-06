package com.jack.kafka;

import lombok.Data;

import java.util.Date;

/**
 * @author yangyueming
 */
@Data
public class Message {
    private Long id;    //id

    private String msg; //消息

    private Date sendTime;  //时间戳

}