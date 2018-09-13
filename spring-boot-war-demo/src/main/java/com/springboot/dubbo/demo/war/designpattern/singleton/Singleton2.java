package com.springboot.dubbo.demo.war.designpattern.singleton;

/**
 * 单例模式之懒汉
 * <b>
 *     不推荐使用
 * </b>
 * Created by laonie on 2018/9/13.
 */
public class Singleton2 {
    private static Singleton2 instance;
    private Singleton2(){}

    // 不加同步关键字
    public static Singleton2 getInstance1(){
        if (null == instance) {
            instance = new Singleton2();
        }
        return instance;
    }
    // 加同步关键字
    public synchronized static Singleton2 getInstance(){
        if (null == instance) {
            instance = new Singleton2();
        }
        return instance;
    }
}
