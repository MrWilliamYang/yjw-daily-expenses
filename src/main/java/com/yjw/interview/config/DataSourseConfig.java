package com.yjw.interview.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 数据源配置文件
 * 
 * @description DataSourseConfig.java
 * @author YangJianWei
 * @date 2018年10月10日 上午10:25:39
 * @version $Id: v 0.1
 */
@Configuration
public class DataSourseConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        return dataSource;
    }

}
