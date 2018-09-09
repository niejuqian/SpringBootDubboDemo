package com.springboot.dubbo.demo.consumer.controller;

import com.springboot.dubbo.demo.common.dto.EmptyDto;
import com.springboot.dubbo.demo.common.web.ValidateException;
import com.springboot.dubbo.demo.consumer.bean.EditUserDto;
import com.springboot.dubbo.demo.consumer.bean.UserDto;
import com.springboot.dubbo.demo.consumer.service.UserAndTeacherService;
import com.springboot.dubbo.demo.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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
    private UserAndTeacherService userAndTeacherService;

    @GetMapping("/info")
    public UserDto findUser(String userName){
        UserDto result = new UserDto();
        result.setUserName("未找到");
        UserEntity userEntity = userAndTeacherService.findUser(userName);
        if (null != userEntity) {
            result.setUserName(userEntity.getUserName());
            result.setAge(userEntity.getUserAge());
        }
        return result;
    }

    @PostMapping("/save")
    public EmptyDto save(@Valid @RequestBody EditUserDto dto, BindingResult result){
        if (result.hasErrors()) {
            throw new ValidateException(result.getAllErrors().get(0).getDefaultMessage());
        }
        userAndTeacherService.saveInfo(dto.getUserName(),dto.getUserAge(),dto.getTeacherAge());
        return EmptyDto.build();
    }
}
