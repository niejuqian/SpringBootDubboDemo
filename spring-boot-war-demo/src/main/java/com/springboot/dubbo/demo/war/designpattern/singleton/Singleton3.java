package com.springboot.dubbo.demo.war.designpattern.singleton;

/**
 * 单例模式之双重检测
 * <b>
 *     推荐使用
 * </b>
 * Created by laonie on 2018/9/13.
 */
public class Singleton3 {
    private static Singleton3 instance;
    private Singleton3(){}
    public static Singleton3 getInstance(){
        if (null == instance) {
            synchronized (Singleton3.class) {
                if (null == instance) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
