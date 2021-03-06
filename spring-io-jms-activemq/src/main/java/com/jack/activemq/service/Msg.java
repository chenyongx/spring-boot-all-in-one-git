package com.jack.activemq.service;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.Date;

/**
 * @author yangyueming
 */
public class Msg implements MessageCreator {

    @Override
    public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage(new Date() + " 测试消息");
    }

}
