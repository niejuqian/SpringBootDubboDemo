package com.springboot.dubbo.demo.war.util;

/**
 * Created by laonie on 2018/9/1.
 */
public class Test {

    public static void main(String[] args) {
        WeekDay weekDay = WeekDay.MON;
        System.out.println(weekDay);
        System.out.println(weekDay.nextDay());
    }
}
