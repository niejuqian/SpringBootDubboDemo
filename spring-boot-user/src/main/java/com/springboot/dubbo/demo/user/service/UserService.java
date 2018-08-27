package com.springboot.dubbo.demo.user.service;


import com.springboot.dubbo.demo.user.entity.UserEntity;

/**
 * 此接口为dubbo对外暴露接口定义
 * @author niejiuqian
 * @date 2018/8/20
 */
public interface UserService {
    /**
     * 根据用户名称查询用户信息
     * @param userName
     * @return
     */
    UserEntity findUser(String userName);

    /**
     * 保存信息
     * @param userEntity 用户姓名
     * @return
     */
    UserEntity save(UserEntity userEntity);
}
