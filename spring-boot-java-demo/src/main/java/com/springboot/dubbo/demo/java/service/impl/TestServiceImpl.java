package com.springboot.dubbo.demo.java.service.impl;

import com.springboot.dubbo.demo.java.service.TestService;
import org.springframework.stereotype.Service;

/**
 * Created by niejiuqian on 2018/8/28.
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public String getUserName() {
        return "Hello Java Demo";
    }
}
