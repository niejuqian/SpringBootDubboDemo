package com.springboot.dubbo.demo.provider.service;

import com.springboot.dubbo.demo.provider.entity.TeacherEntity;

/**
 * Created by niejiuqian on 2018/8/21.
 */
public interface TeacherService {
    TeacherEntity save(TeacherEntity entity);
}
