package com.springboot.dubbo.demo.multi.datasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        entityManagerFactoryRef = "entityManagerFactoryTest1",
        transactionManagerRef = "transactionManagerTest1",
        basePackages = {"com.springboot.dubbo.demo.**.jpa.test1"}
)
public class Test1DataSourceConfigure {
    @Autowired
    @Qualifier("test1DataSource")
    private DruidDataSource test1DataSource;

    @Bean(name = "entityManagerTest1")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryBean(builder).getObject().createEntityManager();
    }

    @Bean(name = "entityManagerFactoryTest1")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(test1DataSource)
                .properties(getVendorProperties(test1DataSource))
                .packages(new String[]{"com.springboot.dubbo.demo.**.entity"})
                .build();
    }

    @Autowired
    private JpaProperties jpaProperties;
    private Map<String,String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Bean(name = "transactionManagerTest1")
    public PlatformTransactionManager transactionManagerTest(EntityManagerFactoryBuilder builder){
        return new JpaTransactionManager(entityManagerFactoryBean(builder).getObject());
    }
}
