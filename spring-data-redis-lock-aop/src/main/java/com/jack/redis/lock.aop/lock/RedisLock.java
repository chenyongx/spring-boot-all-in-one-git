package com.jack.redis.lock.aop.lock;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 分布式锁
 *
 */
@Component
@Slf4j
public class RedisLock {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 加锁
     * @param key
     * @param value  当前时间+超时时间 也就是时间戳
     * @return
     */
    public boolean lock(String key,String value){
        if(stringRedisTemplate.opsForValue().setIfAbsent(key,value)){
            return true;
        }

        String currentValue = stringRedisTemplate.opsForValue().get(key);

        if(!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis()){
            String oldValue = stringRedisTemplate.opsForValue().getAndSet(key,value);
            if(!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue) ){
                return true;
            }
        }
        return false;
    }


    /**
     * 解锁
     * @param key
     * @param value
     */
    public void unlock(String key,String value){
        try {
            String currentValue = stringRedisTemplate.opsForValue().get(key);
            if(!StringUtils.isEmpty(currentValue) && currentValue.equals(value) ){
                stringRedisTemplate.opsForValue().getOperations().delete(key);
            }
        } catch (Exception e) {
            log.error("[Redis分布式锁] 解锁出现异常了，{}",e);
        }
    }

}
