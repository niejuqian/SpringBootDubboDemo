package com.springboot.dubbo.demo.common.permission;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 按鈕权限定义
 * Created by Benson on 2018/4/9.
 */
@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ButtonPermissionDefiner {

    String name();      //名称

    String group();     //所属权限组

    String parentCode();    // 所属父代码

}
