package com.jack.mvc.exception;

import java.io.Serializable;

import com.jack.mvc.exception.JackTools;
import com.jack.mvc.exception.MessageKey;
import lombok.Getter;
import lombok.Setter;

/**
 * 自定义系统异常类
 *
 * @author yangyueming
 */
@Getter
@Setter
public class JackException extends Exception implements Serializable {

    private static final long serialVersionUID = -8436383747577940435L;
    private String result;
    private MessageKey returnMessage;

    /**
     * 构造方法
     */
    public JackException() {
    }

    /**
     * coros自定义业务异常
     *
     * @param messageKey 消息编号
     */
    public JackException(String messageKey) {
        super(JackTools.getMessageByKey(messageKey));
        this.setResult(messageKey);
    }


    /**
     * coros自定义业务异常
     *
     * @param result 消息编号
     * @param message 消息
     */
    public JackException(String result, String message) {
        super(message);
        this.setResult(result);
    }


    /**
     * coros自定义业务异常
     *
     * @param e 异常信息
     * @param result 消息编号
     * @param message 占位符中参数
     */
    public JackException(Exception e, String result, String message) {
        super(message, e);
        this.setResult(result);
    }
}
