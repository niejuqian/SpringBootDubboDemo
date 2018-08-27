package com.springboot.dubbo.demo.controller;

import com.springboot.dubbo.demo.cache.TestCache;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by niejiuqian on 2018/8/27.
 */
@Controller
public class TestRedisController {

    @Autowired
    private TestCache testCache;
    private static final String KEY = "testkey";

    @GetMapping("/hello")
    @ResponseBody
    public  String hello(){
        String val = testCache.findCache(KEY);
        if (StringUtils.isBlank(val)) {
            val =KEY + System.currentTimeMillis();
            testCache.save(KEY,val);
        }
        return "hello  jack ===>>>" + val;
    }
}
