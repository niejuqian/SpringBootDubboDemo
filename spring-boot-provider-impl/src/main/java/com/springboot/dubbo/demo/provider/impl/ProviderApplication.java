package com.springboot.dubbo.demo.provider.impl;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * dubbo 生产者启动入口及配置
 * @author niejiuqian
 * @date 2018/8/20
 */
@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan(basePackages = "com.springboot.dubbo.demo")
@EntityScan("com.springboot.dubbo.demo.**.entity")
@EnableJpaRepositories("com.springboot.dubbo.demo.**.jpa")
public class ProviderApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder().sources(ProviderApplication.class,ProviderDubboConfig.class).run(args);
    }
}
