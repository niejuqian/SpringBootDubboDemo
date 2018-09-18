package com.springboot.dubbo.demo.multi.datasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * Created by laonie on 2018/9/18.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryTest",
        transactionManagerRef = "transactionManagerTest",
        basePackages = {"com.springboot.dubbo.demo.**.jpa.test"}
)
public class TestDataSourceConfigure {
    @Autowired
    @Qualifier("testDataSource")
    private DruidDataSource testDataSource;

    @Primary
    @Bean(name = "entityManagerTest")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryBean(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name = "entityManagerFactoryTest")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(testDataSource)
                .properties(getVendorProperties(testDataSource))
                .packages(new String[]{"com.springboot.dubbo.demo.**.entity"})
                .build();
    }

    @Autowired
    private JpaProperties jpaProperties;
    private Map<String,String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Primary
    @Bean(name = "transactionManagerTest")
    public PlatformTransactionManager transactionManagerTest(EntityManagerFactoryBuilder builder){
        return new JpaTransactionManager(entityManagerFactoryBean(builder).getObject());
    }
}
