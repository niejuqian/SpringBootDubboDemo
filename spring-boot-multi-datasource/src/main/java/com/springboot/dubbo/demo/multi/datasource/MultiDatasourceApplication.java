package com.springboot.dubbo.demo.multi.datasource;

import com.springboot.dubbo.demo.multi.datasource.servlet.MyFilter;
import com.springboot.dubbo.demo.multi.datasource.servlet.MyListener;
import com.springboot.dubbo.demo.multi.datasource.servlet.MyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laonie on 2018/9/18.
 */
@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan(basePackages = "com.springboot.dubbo.demo")
@EntityScan("com.springboot.dubbo.demo.**.entity")
@ServletComponentScan
//@EnableJpaRepositories("com.springboot.dubbo.demo.**.jpa")
public class MultiDatasourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MultiDatasourceApplication.class,args);
    }

    /*@Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean myFilter = new FilterRegistrationBean();
        myFilter.setFilter(new MyFilter());
        List<String> filterUrlPatterns = new ArrayList<>();
        filterUrlPatterns.add("*//*");
        myFilter.setUrlPatterns(filterUrlPatterns);
        myFilter.setOrder(1);
        return myFilter;
    }

    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean myServlet = new ServletRegistrationBean();
        myServlet.addUrlMappings("/myServlet");
        myServlet.setServlet(new MyServlet());
        return myServlet;
    }

    @Bean
    public ServletListenerRegistrationBean<MyListener> myListener(){
        ServletListenerRegistrationBean<MyListener> myListener = new ServletListenerRegistrationBean<>();
        myListener.setListener(new MyListener());
        return myListener;
    }*/
}
