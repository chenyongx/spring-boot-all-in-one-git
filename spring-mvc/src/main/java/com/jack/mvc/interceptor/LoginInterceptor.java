package com.jack.mvc.interceptor;

import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jack
 */
@Service
@Log
public class LoginInterceptor extends HandlerInterceptorAdapter {

        @Override
        public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler){

        String userId = request.getParameter("userId");
        if (StringUtils.isNotBlank(userId)) {
            return false;
        }
    }

}