package com.jack.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <desc>
 *    系统日志切面处理
 * </desc>
 *
 * @author Tom
 * @date 2018/7/28
 **/
@Aspect
@Component
public class SysLogAspect {

    @Autowired
//    SystemLogService systemLogService;

    //切面入口
    @Pointcut("@annotation(com.jack.aop.annotation.SysLog)")
    public void logPointCut() {}

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;

        //保存日志
//        saveSysLog(point, time);

        return result;
    }



}
