package com.springboot.dubbo.demo.consumer;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 消费者配置文件
 * @author niejiuqian
 * @date 2018/8/21
 */
@Configuration
@ImportResource({"classpath:dubbo-consumer.xml"})
public class ConsumerDubboConfig {
}
