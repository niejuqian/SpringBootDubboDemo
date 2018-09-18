package com.springboot.dubbo.demo.multi.datasource.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by niejiuqian on 2018/8/21.
 */
public class EditUserDto implements Serializable {
    @NotBlank(message = "用户姓名不能为空")
    private String userName;
    @NotNull(message = "用户年龄不能为空")
    @Min(value = 1,message = "用户年龄错误，不满1岁的按1岁传参")
    @Max(value = 150,message = "用户年龄错误")
    private Integer userAge;
    @NotNull(message = "教龄不能为空")
    @Min(value = 0,message = "教龄错误")
    @Max(value = 60,message = "教龄错误")
    private Integer teacherAge;

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

    public Integer getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(Integer teacherAge) {
        this.teacherAge = teacherAge;
    }
}
