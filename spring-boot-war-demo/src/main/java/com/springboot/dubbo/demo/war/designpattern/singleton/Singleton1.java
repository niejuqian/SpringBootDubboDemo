package com.springboot.dubbo.demo.war.designpattern.singleton;

/**
 * 单例模式之恶汉
 * <b>
 *     不推荐使用
 * </b>
 * Created by laonie on 2018/9/13.
 */
public class Singleton1 {
    private static Singleton1 instance = new Singleton1();
    private Singleton1(){}
    public static Singleton1 getInstance(){
        return instance;
    }
}
