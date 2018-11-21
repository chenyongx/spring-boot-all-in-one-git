package com.jack.redis.lock.aop.lock;

import com.jack.redis.lock.aop.exception.LockException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * 分布式锁
 *
 */
@Aspect
@Configuration
public class LockMethodInterceptor {

    @Autowired
    public LockMethodInterceptor( CacheKeyGenerator cacheKeyGenerator) {
        this.cacheKeyGenerator = cacheKeyGenerator;
    }

    private final CacheKeyGenerator cacheKeyGenerator;

    @Resource
    private RedisLock redisLock;

    @Around("execution(public * *(..)) && @annotation(com.jack.redis.lock.aop.lock.Lock)")
    public Object interceptor(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        Lock lock = method.getAnnotation(Lock.class);
        if (StringUtils.isEmpty(lock.key())) {
            throw new RuntimeException("lock key can't be null...");
        }
        final String lockKey = cacheKeyGenerator.getLockKey(pjp);
        long time = System.currentTimeMillis() + lock.expire();
        try {
            //key不存在才能设置成功
            final boolean success = redisLock.lock(lockKey,String.valueOf(time));
            if (success) {
                return pjp.proceed();
            } else {
                throw new LockException(String.format("Lock.%s",lockKey));
            }

        } finally {
            //如果演示的话需要注释该代码;实际应该放开
            redisLock.unlock(lockKey,String.valueOf(time));
        }
    }

}