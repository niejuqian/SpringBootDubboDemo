package com.springboot.dubbo.demo.multi.datasource.service;

import com.springboot.dubbo.demo.multi.datasource.entity.UserEntity;
import com.springboot.dubbo.demo.multi.datasource.jpa.test.TestUserRepository;
import com.springboot.dubbo.demo.multi.datasource.jpa.test1.Test1UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by laonie on 2018/9/18.
 */
@Service
public class UserService {
    @Autowired
    private TestUserRepository userRepository;
    @Autowired
    private Test1UserRepository test1UserRepository;

    public List<UserEntity> findUserList(){
        return userRepository.findAll();
    }


    public List<UserEntity> findUserList1(){
        return test1UserRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public void save(String userName, Integer userAge) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserAge(userAge);
        userEntity.setUserName(userName);
        userRepository.save(userEntity);
        int i = 5/0;
        test1UserRepository.save(userEntity);
    }
}
