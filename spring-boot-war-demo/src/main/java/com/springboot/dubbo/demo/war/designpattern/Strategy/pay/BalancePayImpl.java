package com.springboot.dubbo.demo.war.designpattern.Strategy.pay;

import java.math.BigDecimal;

/**
 * 余额支付
 * Created by laonie on 2018/9/12.
 */
public class BalancePayImpl implements IPay {
    @Override
    public BigDecimal doPay(String orderId, BigDecimal orderAmount) throws Exception {
        System.out.println("开始使用余额抵扣支付.");
        // 根据订单查询订单信息
        // 根据订单用户信息，查询用户余额信息
        // 减掉用户余额
        // 插入用户余额支付流水记录
        // 返回实际余额支付额度
        return new BigDecimal("20");
    }
}
