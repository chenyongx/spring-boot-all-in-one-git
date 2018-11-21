package com.jack.redis.lock.aop.lock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 分布式锁
 *
 */
@Configuration
public class LockConfiguration {

    @Bean
    public LockKeyGenerator lockKeyGenerator(){
        return new LockKeyGenerator();
    }

//    @Bean
//    public RedisLock redisLock(){return new RedisLock();}
}
