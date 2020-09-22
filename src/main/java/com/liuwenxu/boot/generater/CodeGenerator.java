package com.liuwenxu.boot.generater;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Copyright (C), 2015-2020, https://www.liuwenxu.com/
 * FileName: CodeGeneratorDefault
 * Author: liuwenxu
 * Date: 2019/08/08 11:27
 * Description: mybatis-plus 代码生成
 */
public class CodeGenerator {
    /**
     * 读取控制台内容
     *
     * @param tip
     * @return
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        String projectPath = System.getProperty("user.dir");

        GlobalConfig gc = new GlobalConfig()
                .setOutputDir(projectPath +  "/src/main/java")
                .setAuthor("liuwenxu")
                .setOpen(false)
                .setSwagger2(true); // 实体属性 Swagger2 注解

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig()
                .setUrl("jdbc:mysql://localhost:3306/df?serverTimezone=UTC&characterEncoding=utf-8&useSSL=false")
                // dsc.setSchemaName("public")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUsername("root")
                .setPassword("1q2w3e");

        // 包配置
//        String package_name = scanner("包名（例如：user）");
        String package_name = "boot";
        PackageConfig pc = new PackageConfig()
                .setModuleName(package_name)
                .setParent("com.liuwenxu");

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
//        focList.add(new FileOutConfig("templates/entity-mine.java.ftl") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
//                return projectPath + "/src/main/java/com/liuwenxu/entity/" + package_name +
//                        "/" + tableInfo.getEntityName() + StringPool.DOT_JAVA;
//            }
//        });

        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath +  "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);

        // 配置模板
        // 指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        TemplateConfig templateConfig = new TemplateConfig()
                .setMapper("templates/mp/mapper-mine.java")
                .setService("templates/mp/service-mine.java")
                .setServiceImpl("templates/mp/serviceImpl-mine.java")
                .setController("templates/mp/controller-mine.java")
                // null避免重复生成
                .setEntity("templates/mp/entity-mine.java")
                .setXml(null);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig()
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                //.setSuperEntityClass("com.baomidou.ant.common.BaseEntity")
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                //strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
                .setInclude(scanner("数据库表名（例如：sys_user）"))
                //strategy.setSuperEntityColumns("id");
                .setControllerMappingHyphenStyle(true)
                .setTablePrefix("df_");

        mpg.setGlobalConfig(gc);
        mpg.setDataSource(dsc);
        mpg.setPackageInfo(pc);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));
        mpg.setTemplate(templateConfig);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
