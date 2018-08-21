package com.springboot.dubbo.demo.provider.impl;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * dubbo 生产者启动入口及配置
 * @author niejiuqian
 * @date 2018/8/20
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.springboot.dubbo.demo")
public class ProviderApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder().sources(ProviderApplication.class,ProviderDubboConfig.class).run(args);
    }
}
