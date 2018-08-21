package com.springboot.dubbo.demo.common.util.func;

public interface Func1<T, TReturn> {
    TReturn call(T t);
}

