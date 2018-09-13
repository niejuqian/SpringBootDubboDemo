package com.springboot.dubbo.demo.war.designpattern.singleton;

/**
 * 单例模式之静态内部类
 * <b>
 *     推荐使用
 * </b>
 * Created by laonie on 2018/9/13.
 */
public class Singleton4 {
    private static Singleton4 instance;
    private Singleton4(){}
    public static Singleton4 getInstance(){
        return SingletonHandler.SINGLETON;
    }

    private static class SingletonHandler {
        private final static Singleton4 SINGLETON = new Singleton4();
    }
}
