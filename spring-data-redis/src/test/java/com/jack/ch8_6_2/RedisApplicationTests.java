package com.jack.ch8_6_2;

import com.jack.redis.RedisApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RedisApplication.class)
@WebAppConfiguration
public class RedisApplicationTests {

    @Test
    public void contextLoads() {
    }

}
