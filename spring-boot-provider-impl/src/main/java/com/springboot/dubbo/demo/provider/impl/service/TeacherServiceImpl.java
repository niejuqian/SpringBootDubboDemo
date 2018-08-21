package com.springboot.dubbo.demo.provider.impl.service;

import com.springboot.dubbo.demo.provider.entity.TeacherEntity;
import com.springboot.dubbo.demo.provider.impl.jpa.TeacherRepository;
import com.springboot.dubbo.demo.provider.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * Created by niejiuqian on 2018/8/21.
 */
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TeacherEntity save(TeacherEntity entity) {
        Assert.notNull(entity,"老师对象不能为空");
        return teacherRepository.save(entity);
    }
}
