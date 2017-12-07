package com.jack.interceptor;

import com.jack.annotation.DisableAuth;
import com.jack.entity.Account;
import com.jack.exception.MessageKey;
import com.jack.exception.JackException;
import com.jack.service.AccountService;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.DispatcherType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author yangyueming
 */
@Component
@Log4j2
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private AccountService accountService;

    /**
     * 判断是否鉴权
     *
     * @param auth 权限注解
     * @return 是否拦截
     */
    private static boolean isDisableAuth(DisableAuth auth) {
        return auth != null;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        HandlerMethod method = (HandlerMethod) handler;
        // 1. 判断是否鉴权
        DisableAuth auth = method.getMethod().getAnnotation(DisableAuth.class);
        if (isDisableAuth(auth)) {
            return super.preHandle(request, response, handler);
        }
        // 2. 获取token,检查token是否为空
        String accessToken = getAuthToken(request);
        if (StringUtils.isBlank(accessToken)) {
            throw new JackException(MessageKey.ACCESS_TOKEN_IS_NULL);
        }

        // 3. 查询token是否正确
        Date nowDate = new Date();
        Account account = accountService.findAccessTokenIsValid(accessToken, nowDate);
        if (account == null) {
            throw new JackException(MessageKey.ACCESS_TOKEN_IS_INVALID);
        }

        // 4. 查看token是否过期
        Date today = DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH);
        if (account.getValidityDate() != null && today.compareTo(account.getValidityDate()) > -1) {
            throw new JackException(MessageKey.ACCESS_TOKEN_IS_INVALID);
        }
        // 异常错误
        if (DispatcherType.ERROR == request.getDispatcherType()) {
            throw new JackException(MessageKey.SYSTEM_ERROR);
        }
        return super.preHandle(request, response, handler);
    }

    /**
     * 获取http请求头部或者参数中的token值
     *
     * @param request http请求传递的值
     * @return 返回token
     */
    private String getAuthToken(HttpServletRequest request) {
        String token = request.getParameter("accessToken");
        if (token == null) {
            token = request.getHeader("accessToken");
        }
        return token;
    }

}
