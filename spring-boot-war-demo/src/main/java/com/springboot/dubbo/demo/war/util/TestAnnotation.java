package com.springboot.dubbo.demo.war.util;

import java.lang.annotation.*;

/**
 * 自定义注解
 * Created by laonie on 2018/9/11.
 */
@Documented
// 定义注解声明周期
@Retention(RetentionPolicy.RUNTIME)
// 定义注解可以用在哪些地方
@Target({
        ElementType.TYPE, // 类、接口、枚举
        ElementType.FIELD, // 成员变量、对象、属性（包括enum实例）
        ElementType.PARAMETER, // 参数
        ElementType.METHOD}) // 方法
public @interface TestAnnotation {
    /**
     * 描述
     * @return
     */
    String desc() default "";

    /**
     * id
     * @return
     */
    int id();
}
