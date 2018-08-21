package com.springboot.dubbo.demo.consumer.controller;

import com.springboot.dubbo.demo.consumer.bean.UserDto;
import com.springboot.dubbo.demo.provider.entity.UserEntity;
import com.springboot.dubbo.demo.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 这里调用了UserService Dubbo服务
 * 跟普通的spring mvc调用方式一致
 * @author niejiuqian
 * @date 2018/8/20
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/info")
    @ResponseBody
    public UserDto findUser(String userName){
        UserDto result = new UserDto();
        result.setUserName("未找到");
        UserEntity userEntity = userService.findUser(userName);
        if (null != userEntity) {
            result.setUserName(userEntity.getName());
            result.setAge(userEntity.getAge());
        }
        return result;
    }
}
