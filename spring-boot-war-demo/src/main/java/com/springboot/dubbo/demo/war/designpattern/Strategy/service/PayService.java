package com.springboot.dubbo.demo.war.designpattern.Strategy.service;

import com.springboot.dubbo.demo.war.designpattern.Strategy.bean.PayInfo;

/**
 * 支付业务
 * Created by laonie on 2018/9/12.
 */
public interface PayService {

    /**
     * 支付
     * @param info
     * @throws Exception
     */
    void doPay(PayInfo info) throws Exception;
}
