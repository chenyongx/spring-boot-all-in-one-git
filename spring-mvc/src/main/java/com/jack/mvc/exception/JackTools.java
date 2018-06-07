package com.jack.mvc.exception;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 工具类.
 *
 * @author yangyueming
 */
public class JackTools {

    /**
     * 私有构造方法，不允许实例化
     */
    private JackTools() {
    } // End Tools


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
