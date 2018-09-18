package com.springboot.dubbo.demo.multi.datasource.controller;

import com.springboot.dubbo.demo.multi.datasource.dto.EditUserDto;
import com.springboot.dubbo.demo.multi.datasource.entity.UserEntity;
import com.springboot.dubbo.demo.multi.datasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by laonie on 2018/9/18.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list/{type}")
    public List<UserEntity> findUserList(@PathVariable("type") int type){
        if (type == 1) {
            return userService.findUserList1();
        }
        return userService.findUserList();
    }

    @PostMapping("/save")
    public String saveUser(@Valid @RequestBody EditUserDto dto, BindingResult result){
        if (result.hasErrors()) {
            return result.getAllErrors().get(0).getDefaultMessage();
        }
        userService.save(dto.getUserName(),dto.getUserAge());
        return "save success";
    }

    @GetMapping("/test")
    public String test(){
        return "success";
    }


}
