package com.springboot.dubbo.demo.common.util.action;

public interface Action<T> {
    void call(T t);
}


