package com.jack.ch8_5;

import com.jack.cache.simple.CacheSimpleApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CacheSimpleApplication.class)
@WebAppConfiguration
public class CacheSimpleApplicationTests {

    @Test
    public void contextLoads() {
    }

}
