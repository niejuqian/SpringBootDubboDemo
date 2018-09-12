package com.springboot.dubbo.demo.war.designpattern.Strategy.pay;

import java.math.BigDecimal;

/**
 * Created by laonie on 2018/9/12.
 */
public class WxAPPPayImpl extends AbstractWxPay {
    @Override
    protected BigDecimal pay(BigDecimal orderAmount) {
        System.out.println("开始调用微信APP支付...");
        return orderAmount;
    }
}
