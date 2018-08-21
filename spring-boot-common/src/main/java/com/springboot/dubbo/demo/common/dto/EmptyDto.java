package com.springboot.dubbo.demo.common.dto;

/**
 * 返回空
 *
 * @author 6213
 * @date 2018/5/14
 */
public class EmptyDto extends Dto {

    public static EmptyDto build(){
        return new EmptyDto();
    }
}
