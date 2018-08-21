package com.springboot.dubbo.demo.provider.impl;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 生产者配置文件
 * @author niejiuqian
 * @date 2018/8/21
 */
@Configuration
@ImportResource({"classpath:dubbo-provider.xml"})
public class ProviderDubboConfig {
}
