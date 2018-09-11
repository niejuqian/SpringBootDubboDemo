package com.springboot.dubbo.demo.war.util;

/**
 * 使用注解
 * Created by laonie on 2018/9/11.
 */
@TestAnnotation(id = 1,desc = "这是类上面声明的注解")
public class UserAnnotation {
    @TestAnnotation(id = 2,desc = "这是方法上面声明的注解")
    public String getInfo(@TestAnnotation(id = 3,desc = "这是参数上声明的注解") String name){
        return "Hello "+ name;
    }
}
