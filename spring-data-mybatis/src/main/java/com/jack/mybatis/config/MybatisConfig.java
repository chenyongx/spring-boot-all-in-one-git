package com.jack.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置Mapper的扫描包路径
 * @author yangyueming
 */
@Configuration
@MapperScan("com.jack.mybatis.dao")
public class MybatisConfig {

}  