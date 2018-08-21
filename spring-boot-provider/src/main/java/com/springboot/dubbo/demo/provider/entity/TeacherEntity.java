package com.springboot.dubbo.demo.provider.entity;

import com.springboot.dubbo.demo.common.bean.UUIDEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by niejiuqian on 2018/8/20.
 */
@Entity
@Table(name = "t_teacher_info")
public class TeacherEntity extends UUIDEntity {
    @Column(name = "teacher_name")
    private String teacherName;
    @Column(name = "teacher_age")
    private Integer teacherAge;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(Integer teacherAge) {
        this.teacherAge = teacherAge;
    }
}
