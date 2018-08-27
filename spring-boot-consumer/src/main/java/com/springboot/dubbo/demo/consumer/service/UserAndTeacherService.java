package com.springboot.dubbo.demo.consumer.service;

import com.springboot.dubbo.demo.provider.entity.TeacherEntity;
import com.springboot.dubbo.demo.provider.service.TeacherService;
import com.springboot.dubbo.demo.user.entity.UserEntity;
import com.springboot.dubbo.demo.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by niejiuqian on 2018/8/27.
 */
@Service
public class UserAndTeacherService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserService userService;
    @Autowired
    private TeacherService teacherService;

    public UserEntity findUser(String userName) {
        return userService.findUser(userName);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean saveInfo(String userName, Integer userAge, Integer teacherAge) {
        logger.info("========>>>>开始处理业务");
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userName);
        userEntity.setUserAge(userAge);
        logger.info("========>>>>开始保存用户信息");
        userService.save(userEntity);

        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setTeacherAge(teacherAge);
        teacherEntity.setTeacherName(userName);
        logger.info("========>>>>开始保存教师信息");
        teacherService.save(teacherEntity);
        return true;
    }
}
