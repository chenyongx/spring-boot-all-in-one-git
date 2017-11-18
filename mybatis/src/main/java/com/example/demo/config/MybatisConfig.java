package com.example.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置Mapper的扫描包路径
 */
@Configuration
@MapperScan("com.example.demo.dao")
public class MybatisConfig {

}  