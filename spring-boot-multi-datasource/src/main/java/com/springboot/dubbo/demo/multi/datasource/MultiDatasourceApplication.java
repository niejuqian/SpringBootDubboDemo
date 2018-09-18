package com.springboot.dubbo.demo.multi.datasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by laonie on 2018/9/18.
 */
@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan(basePackages = "com.springboot.dubbo.demo")
@EntityScan("com.springboot.dubbo.demo.**.entity")
//@EnableJpaRepositories("com.springboot.dubbo.demo.**.jpa")
public class MultiDatasourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MultiDatasourceApplication.class,args);
    }
}
