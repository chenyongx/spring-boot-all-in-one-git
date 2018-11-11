package com.jack.global.exception.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangyueming
 *  全局异常处理
 *  1 捕获json
 */
@ControllerAdvice(basePackages = "com.jack.global.exception.controller")
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String, Object> errorResult() {
        // 实际开发中，将错误日志记录在mongodb中，分析
        Map<String, Object> errorResultMap = new HashMap<>();
        errorResultMap.put("errorCode", "500");
        errorResultMap.put("errorMessage", "系统错误");
        return errorResultMap;
    }
}
