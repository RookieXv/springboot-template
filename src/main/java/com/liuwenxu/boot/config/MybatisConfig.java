package com.liuwenxu.boot.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Copyright (C), 2015-2020, https://liuwenxu.com/
 * FileName: MybatisConfig
 * Author: liuwenxu
 * Date: 2019/8/1 14:58
 * Description: mybatis-plus分页插件
 */
@Configuration
@ConditionalOnClass(value = {MapperScannerConfigurer.class})
@EnableTransactionManagement
@MapperScan("com.liuwenxu.boot.**.mapper")
public class MybatisConfig {


    /**
     * mybatis-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
