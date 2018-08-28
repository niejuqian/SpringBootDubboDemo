package com.springboot.dubbo.demo.war;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by niejiuqian on 2018/8/28.
 */
@SpringBootApplication
public class WarDemoApplication extends SpringBootServletInitializer{
    public static void main(String[] args) {
        SpringApplication.run(WarDemoApplication.class,args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WarDemoApplication.class);
    }
}
