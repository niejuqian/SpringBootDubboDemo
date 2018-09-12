package com.springboot.dubbo.demo.war.designpattern.Strategy.pay;

import java.math.BigDecimal;

/**
 * Created by laonie on 2018/9/12.
 */
public interface IPay {
    /**
     * 支付
     * @param orderId 订单编号
     * @param orderAmount 订单剩余支付金额
     * @return 本次支付实际支付金额
     * @throws Exception
     */
    BigDecimal doPay(String orderId,BigDecimal orderAmount) throws Exception;
}
