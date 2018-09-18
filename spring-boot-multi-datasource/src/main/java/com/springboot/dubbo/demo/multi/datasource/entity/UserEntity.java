package com.springboot.dubbo.demo.multi.datasource.entity;

import com.springboot.dubbo.demo.common.bean.UUIDEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by niejiuqian on 2018/8/20.
 */
@Entity
@Table(name = "u_user_info")
public class UserEntity extends UUIDEntity {
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_age")
    private Integer userAge;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
}
