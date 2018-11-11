package com.jack.aop.request.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author yangyueming
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {
    @Pointcut("execution(public * com.jack.aop.request.controller.*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("url: " + request.getRequestURL());
        log.info("http_method: " + request.getMethod());
        log.info("ip: " + request.getRemoteAddr());
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            log.info("parameterName:{}, value:{}", parameterName, request.getParameter(parameterName));
        }
    }

    @AfterReturning(returning = "response", pointcut = "webLog()")
    public void doAfterReturn(Object response) {
        log.info("response: " + response);
    }

}
