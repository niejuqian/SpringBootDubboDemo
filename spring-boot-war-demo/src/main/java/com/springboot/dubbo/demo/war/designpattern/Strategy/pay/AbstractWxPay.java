package com.springboot.dubbo.demo.war.designpattern.Strategy.pay;

import java.math.BigDecimal;

/**
 * 微信支付抽奖类
 * <p>
 *     因为微信支付还区分了APP、WAP、扫码等支付
 * </p>
 * Created by laonie on 2018/9/12.
 */
public abstract class AbstractWxPay implements IPay{
    @Override
    public BigDecimal doPay(String orderId, BigDecimal orderAmount) throws Exception {
        // 处理微信支付公共业务
        System.out.println("处理微信支付前公共业务.");
        pay(orderAmount);
        System.out.println("处理微信支付后公共业务.");
        return orderAmount;
    }

    protected abstract BigDecimal pay(BigDecimal orderAmount);
}
