package com.jack.vo;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;
import lombok.Getter;
import lombok.Setter;

/**
 * 与Client端交互用的实体类
 *
 * @author yangyueming
 */
@Getter
@Setter
public class ResponseVO implements Serializable {

    private static final long serialVersionUID = 6010481115038758220L;

    private static final String RETURN_OK = "0000";

    private String result;
    private String message;
    private Object data;

    public ResponseVO() {
        this.result = RETURN_OK;
        this.message = getMessageByKey(RETURN_OK);
    }

    public ResponseVO(String messageKey) {
        this.result = messageKey;
        this.message = getMessageByKey(messageKey);
    }

    /**
     * 根据key获取信息
     *
     * @param messageKey key值
     * @return 信息
     */
    public static String getMessageByKey(String messageKey) {
        Locale locale = new Locale("en", "US");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", locale);
        return resourceBundle.getString(messageKey);
    }
}
