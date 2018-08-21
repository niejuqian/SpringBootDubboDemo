package com.springboot.dubbo.demo.consumer.service.impl;

import com.springboot.dubbo.demo.consumer.jpa.UserRepository;
import com.springboot.dubbo.demo.consumer.service.UserService;
import com.springboot.dubbo.demo.provider.entity.TeacherEntity;
import com.springboot.dubbo.demo.provider.entity.UserEntity;
import com.springboot.dubbo.demo.provider.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * dubbo服务业务实现
 * 跟普通的spring mvc实现一样
 * @author niejiuqian
 * @date 2018/8/20
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TeacherService teacherService;

    @Override
    public UserEntity findUser(String userName) {
        return userRepository.findFirstByUserName(userName);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveInfo(String userName, Integer userAge, Integer teacherAge) {
        logger.info("========>>>>开始处理业务");
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userName);
        userEntity.setUserAge(userAge);

        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setTeacherAge(teacherAge);
        teacherEntity.setTeacherName(userName);
        logger.info("========>>>>开始保存教师信息");
        teacherService.save(teacherEntity);

        logger.info("========>>>>教师信息保存成功，开始保存用户信息");
        UserEntity saveResult = userRepository.save(userEntity);
        logger.info("========>>>>用户信息保存成功，产生异常，回滚事务");
        //这里发生异常，测试事务回滚
        Assert.isTrue(saveResult == null,"操作失败");
        return true;
    }
}
