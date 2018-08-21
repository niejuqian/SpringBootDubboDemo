package com.springboot.dubbo.demo.provider.entity;

import java.io.Serializable;

/**
 * Created by niejiuqian on 2018/8/20.
 */
public class UserEntity implements Serializable {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
