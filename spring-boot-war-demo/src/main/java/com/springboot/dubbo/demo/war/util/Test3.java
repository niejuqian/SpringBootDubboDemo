package com.springboot.dubbo.demo.war.util;

/**
 * Created by laonie on 2018/9/20.
 */
public class Test3 {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1 == str2);
        System.out.println(str1 == str2.intern());
        System.out.println(str1.intern() == str2.intern());
        String str3 = new String("abc");
        System.out.println(str3.intern() == str1);
    }
}
