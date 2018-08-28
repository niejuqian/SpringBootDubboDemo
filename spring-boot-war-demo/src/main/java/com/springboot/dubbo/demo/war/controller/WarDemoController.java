package com.springboot.dubbo.demo.war.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by niejiuqian on 2018/8/28.
 */
@Controller
public class WarDemoController {

    @GetMapping("/wardemo/json")
    @ResponseBody
    public Object json(){
        Map<String,Object> result = new HashMap<>();
        result.put("name","Jack");
        result.put("age",18);
        return result;
    }

    @GetMapping("/wardemo/ftl")
    public String ftl(Model model){
        model.addAttribute("name","Jack");
        return "index";
    }
}
