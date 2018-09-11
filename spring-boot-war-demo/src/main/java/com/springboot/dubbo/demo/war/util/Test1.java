package com.springboot.dubbo.demo.war.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 反射获取注解信息
 * Created by laonie on 2018/9/11.
 */
public class Test1 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        UserAnnotation userAnnotation = new UserAnnotation();
        Class cls = userAnnotation.getClass();
        TestAnnotation typeAnnotation = (TestAnnotation) cls.getAnnotation(TestAnnotation.class);
        print(typeAnnotation);
        Method[] methods = cls.getDeclaredMethods();
        if (null != methods && methods.length > 0) {
            for (int i = 0; i < methods.length; i++) {
                Method method = methods[i];
                TestAnnotation methodAnnotation = method.getAnnotation(TestAnnotation.class);
                print(methodAnnotation);
                Parameter[] parameters = method.getParameters();
                Object result = method.invoke(userAnnotation,wrapperParameter(parameters));
                System.out.println("method result=" + result);
            }
        }
    }

    public static Object[] wrapperParameter(Parameter[] parameters) {
        if (null == parameters || parameters.length == 0) return null;
        int capacity = parameters.length;
        Object[] objs = new Object[capacity];
        for (int i = 0; i < capacity; i++) {
            Parameter parameter = parameters[i];
            TestAnnotation paramAnnotation = parameter.getAnnotation(TestAnnotation.class);
            print(paramAnnotation);
            Class typeCls = parameter.getType();
            if (typeCls.isPrimitive()) {
                // 基本类型
                continue;
            }
            if (typeCls.getName().equals(String.class.getName())) {
                // 字符串
                objs[i] = "Jack";
                continue;
            }
            // ... 其他的
        }
        return objs;
    }

    public static void print(TestAnnotation annotation){
        if (null != annotation) {
            System.out.println("id=" + annotation.id() + "，desc=" + annotation.desc());
        }
    }
}
