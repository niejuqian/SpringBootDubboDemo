package com.springboot.dubbo.demo.provider.impl.service;

import com.springboot.dubbo.demo.provider.entity.UserEntity;
import com.springboot.dubbo.demo.provider.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * dubbo服务业务实现
 * 跟普通的spring mvc实现一样
 * @author niejiuqian
 * @date 2018/8/20
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserEntity findUser(String userName) {
        UserEntity entity = new UserEntity();
        entity.setAge(18);
        entity.setName("Jack");
        return entity;
    }
}
