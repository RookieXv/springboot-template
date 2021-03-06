package com.liuwenxu.boot.config;

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
 * Copyright (C), 2015-2020, https://www.liuwenxu.com/
 * FileName: SwaggerConfig
 * Author: liuwenxu
 * Date: 2019/7/10 14:59
 * Description: 接口文档说明  http://localhost:9394/swagger-ui.html#/
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.liuwenxu.boot.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot-template")
                .description("springboot-template")
                .contact(new Contact("liuwenxu", "https://www.liuwenxu.com", "liuwx8102@163.com"))
                .version("1.0")
                .build();
    }

}
