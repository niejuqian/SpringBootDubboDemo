package com.springboot.dubbo.demo.multi.datasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by laonie on 2018/9/18.
 */
@Configuration
public class DataSourceConfigure {
    /**
     * 使用druid数据库连接池
     * @return
     */
    @Bean(name = "testDataSource")
    @Qualifier("testDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test")
    @Primary
    public DruidDataSource testDataSource(){
        return new DruidDataSource();
    }

    /**
     * 使用HikariCp数据库连接池
     * @return
     */
    @Bean(name = "test1DataSource")
    @Qualifier("test1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test1")
    public DruidDataSource test1DataSource(){
        return new DruidDataSource();
    }
}
