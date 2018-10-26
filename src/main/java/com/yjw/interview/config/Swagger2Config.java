package com.yjw.interview.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger2配置类
 * 
 * @description Swagger2Config.java
 * @author YangJianWei
 * @date 2018年10月10日 下午5:47:23
 * @version $Id: v 0.1 
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()// 选择那些路径和 api 会生成document
            .apis(RequestHandlerSelectors.basePackage("com.yjw.interview.controller"))//此处记得替换需要扫描的 controller 包
            .paths(PathSelectors.any())// 对所有路径进行监控
            .build();
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("日常开销服务 APIs")//页面标题
            .description("用于记录以及查询日常开销记录的服务")//详细描述
            .termsOfServiceUrl("")//服务条款网址
            .contact(new Contact("ZongTong", "", ""))//第一个参数：创建者；第二个参数：详情跳转地址；第三个参数：未知
            .version("1.0")//版本号
            .build();
    }
}
