package com.yjw.expenses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 因为添加了数据库组件，所以 autoconfig 会去读取数据源配置，
 * 而新建的项目还没有配置数据源，所以会导致异常出现。
 * 需要在注解  @SpringBootApplication  后面添加以下
 * (exclude = {DataSourceAutoConfiguration.class})
 * 才能启动项目
 * 
 * @description YjwInterviewQuestionsApplication.java
 * @author YangJianWei
 * @date 2018年10月10日 上午9:52:53
 * @version $Id: v 0.1 
 */
@EnableSwagger2 //配置开启Swagger
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class YjwDailyExpensesApplication {

    public static void main(String[] args) {
        SpringApplication.run(YjwDailyExpensesApplication.class, args);
    }
}
