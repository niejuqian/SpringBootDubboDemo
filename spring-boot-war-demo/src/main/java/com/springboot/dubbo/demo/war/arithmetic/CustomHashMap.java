package com.springboot.dubbo.demo.war.arithmetic;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义实现HashMap
 * Created by laonie on 2018/9/5.
 */
public class CustomHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("语文", 1);
        map.put("数学", 2);
        map.put("英语", 3);
        map.put("历史", 4);
        map.put("政治", 5);
        map.put("地理", 6);
        map.put("生物", 7);
        map.put("化学", 8);
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}
