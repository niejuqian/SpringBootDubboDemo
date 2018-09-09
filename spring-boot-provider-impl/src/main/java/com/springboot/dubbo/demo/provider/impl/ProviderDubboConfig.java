package com.springboot.dubbo.demo.provider.impl;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 生产者配置文件
 * @author niejiuqian
 * @date 2018/8/21
 */
@Configuration
@ConfigurationProperties
//@ImportResource({"classpath:dubbo-provider.xml"})
public class ProviderDubboConfig {

    @Value("${dubbo.application.name}")
    private String applicationName;
    @Value("${dubbo.protocol.port}")
    private Integer protocolPort;
    @Value("${dubbo.registry.address}")
    private String registryAddress;

    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(applicationName);
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(registryAddress);
        registryConfig.setClient("curator");
        return registryConfig;
    }


    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig config = new ProtocolConfig();
        config.setPort(protocolPort);
        return config;
    }
}
