package com.springboot.dubbo.demo.java;

import com.springboot.dubbo.demo.java.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动非WEB项目
 * <p>
 *     主要是不要依赖spring-boot-starter-web就可以
 *     就是不用tomcat等容器启动项目
 * </p>
 * @author niejiuqian
 * @date 2018/8/28
 */
@SpringBootApplication
public class JavaDemoApplication implements CommandLineRunner{

    @Autowired
    private TestService testService;

    public static void main(String[] args) {
        /*ConfigurableApplicationContext context = SpringApplication.run(JavaDemoApplication.class,args);
        TestService testService = (TestService) context.getBean("testServiceImpl");
        String name = testService.getUserName();
        System.out.println(name);*/

        SpringApplication.run(JavaDemoApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        String name = testService.getUserName();
        System.out.println(name);

        // 使程序不退出
        Thread.currentThread().join();
    }
}
