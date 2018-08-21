package com.springboot.dubbo.demo.consumer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * 消费者服务器启动入口及配置
 * @author niejiuqian
 * @date 2018/8/20
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.springboot.dubbo.demo")
public class ConsumerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder().sources(ConsumerApplication.class,ConsumerDubboConfig.class).run(args);
    }
}
