package com.springboot.dubbo.demo.user.service.impl;

import com.springboot.dubbo.demo.user.entity.UserEntity;
import com.springboot.dubbo.demo.user.jpa.UserRepository;
import com.springboot.dubbo.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * dubbo服务业务实现
 * 跟普通的spring mvc实现一样
 * @author niejiuqian
 * @date 2018/8/20
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity findUser(String userName) {
        return userRepository.findFirstByUserName(userName);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }
}
