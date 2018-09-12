package com.springboot.dubbo.demo.war.designpattern.Strategy.pay;

import java.math.BigDecimal;

/**
 * 积分支付
 * Created by laonie on 2018/9/12.
 */
public class PointPayImpl implements IPay {
    @Override
    public BigDecimal doPay(String orderId, BigDecimal orderAmount) throws Exception {
        System.out.println("开始使用积分抵扣支付.");
        // 根据订单查询订单信息
        // 根据订单用户信息，查询用户积分信息
        // 查询积分抵扣比例等配置信息（一个积分能抵扣多少金额、一个单最多能使用多少积分进行抵扣）
        // 减掉积分（插入积分支付流水记录）
        // 返回本次抵扣金额
        return new BigDecimal("10");
    }
}
