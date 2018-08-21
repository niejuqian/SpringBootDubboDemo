package com.springboot.dubbo.demo.common.web;

/**
 * 参数校验异常
 *
 * @author 6213
 * @date 2018/5/3
 */
public class ValidateException extends AppException {

    public ValidateException(String msg) {
        super(msg,StandardResponseHeader.ERROR_PARAM);
    }
}
