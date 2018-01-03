package com.example.demo;

import com.jack.mybatis.dao.ArticleSearchRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticSearchApplicationTests {

    @Autowired
    private ArticleSearchRepository articleSearchRepository;

    @Test
    public void test(){
        System.out.println("演示初始化");
    }

}
