package com.springboot.dubbo.demo.war.util;

/**
 * 使用类替代枚举
 * Created by laonie on 2018/9/1.
 */
public abstract class WeekDay {
    /**构造函数私有化*/
    private WeekDay(){}

    /**获取当前星期几的下一天是星期几*/
    public abstract WeekDay nextDay();

    public final static WeekDay SUN = new WeekDay() {
        @Override
        public WeekDay nextDay() {
            return MON;
        }

        @Override
        public String toString() {
            return "SUM";
        }
    };

    public final static WeekDay MON = new WeekDay() {
        @Override
        public WeekDay nextDay() {
            return SUN;
        }

        @Override
        public String toString() {
            return "MON";
        }
    };
}
