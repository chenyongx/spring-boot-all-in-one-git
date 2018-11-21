package com.jack.redis.lock.aop.lock;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 分布式锁 key解析
 *
 */
public interface CacheKeyGenerator {

    /**
     * 获取AOP参数,生成指定缓存Key
     *
     * @param pjp PJP
     * @return 缓存KEY
     */
    String getLockKey(ProceedingJoinPoint pjp);
}