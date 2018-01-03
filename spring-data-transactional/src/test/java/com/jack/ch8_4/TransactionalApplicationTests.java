package com.jack.ch8_4;

import com.jack.transactional.TransactionalApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TransactionalApplication.class)
@WebAppConfiguration
public class TransactionalApplicationTests {

    @Test
    public void contextLoads() {
    }

}
