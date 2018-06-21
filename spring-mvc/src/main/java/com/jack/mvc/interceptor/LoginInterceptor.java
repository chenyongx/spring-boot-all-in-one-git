package com.jack.mvc.interceptor;

import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Service
@Log
public class LoginInterceptor extends HandlerInterceptorAdapter { {
//    protected static final Log logger = LogFactory.getLog(LoginInterceptor.class);
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){

        String userId = request.getParameter("userId");
        if (StringUtils.isNotBlank(userId)){
            return false;
        }
    }