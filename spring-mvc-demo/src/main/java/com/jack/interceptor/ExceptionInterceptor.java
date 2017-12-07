package com.jack.interceptor;

import com.alibaba.fastjson.JSON;
import com.jack.exception.MessageKey;
import com.jack.exception.JackException;
import com.jack.exception.JackTools;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.DispatcherType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.json.JSONException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 异常拦截器
 *
 * @author yangyueming
 */
@Component
@Log4j2
public class ExceptionInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
        Object handler, Exception ex)
        throws Exception {
        PrintWriter writer = response.getWriter();
        //response 重置，不然会报错：getOutputStream() has already been called for this response
        response.reset();
        response.setContentType("application/json;charset=UTF-8");
        if (ex != null) {
            String code = "0000";
            String msg;
            if (ex instanceof JackException) {
                code = ((JackException) ex).getResult();
                msg = ex.getMessage();
            } else if (ex instanceof JSONException) {
                log.error("json parse error" + ex.getMessage());
                code = MessageKey.PARAMETER_ERROR;
                msg = JackTools.getMessageByKey(MessageKey.PARAMETER_ERROR);
            } else {
                msg = JackTools.getMessageByKey(MessageKey.SYSTEM_ERROR);
            }
            logger(request, handler, ex);
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("result", code);
            resultMap.put("message", msg);

            JSON.writeJSONString(writer, resultMap);
            writer.flush();
            writer.close();
            return;
        }
        if (DispatcherType.ERROR == request.getDispatcherType()) {
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("result", MessageKey.SYSTEM_ERROR);
            resultMap.put("message", JackTools.getMessageByKey(MessageKey.SYSTEM_ERROR));

            JSON.writeJSONString(writer, resultMap);
            writer.flush();
            writer.close();
            return;
        }
        super.afterCompletion(request, response, handler, ex);
    }

    /**
     * 记录日志
     */
    public void logger(HttpServletRequest request, Object handler, Exception ex) {
        StringBuffer msg = new StringBuffer();
        msg.append("异常拦截日志");
        msg.append("[uri:").append(request.getRequestURI()).append("]");
        Enumeration<String> enumer = request.getParameterNames();
        while (enumer.hasMoreElements()) {
            String name = enumer.nextElement();
            String[] values = request.getParameterValues(name);
            msg.append("[").append(name).append("=");
            if (values != null) {
                int i = 0;
                for (String value : values) {
                    i++;
                    msg.append(value);
                    if (i < values.length) {
                        msg.append("｜");
                    }
                }
            }
            msg.append("]");
        }
        log.error(msg.toString());
    }
}
