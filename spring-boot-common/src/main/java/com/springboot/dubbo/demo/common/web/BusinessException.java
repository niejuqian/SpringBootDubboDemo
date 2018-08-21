package com.springboot.dubbo.demo.common.web;

/**
 * 业务异常
 *
 * @author 6213
 * @date 2018/5/3
 */
public class BusinessException extends AppException {

    public BusinessException(ResponseHeader responseHeader) {
        super(responseHeader);
    }

    public BusinessException(String message, ResponseHeader responseHeader) {
        super(message, responseHeader);
    }

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(String message, int code) {
        super(message, code);
    }
}
