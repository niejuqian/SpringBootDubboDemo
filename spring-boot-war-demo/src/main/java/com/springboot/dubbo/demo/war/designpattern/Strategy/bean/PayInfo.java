package com.springboot.dubbo.demo.war.designpattern.Strategy.bean;

import com.springboot.dubbo.demo.war.designpattern.Strategy.enums.PayChannel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by laonie on 2018/9/12.
 */
public class PayInfo implements Serializable{
    // 订单编号
    private String orderId;
    // 本次支付金额，如果不传，则默认订单剩余支付金额
    private BigDecimal payAmount;
    // 可以使用组合支付模式：第三方支付（一种） + 内部支付（多种）
    private List<PayChannel> channels;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public List<PayChannel> getChannels() {
        return channels;
    }

    public void setChannels(List<PayChannel> channels) {
        this.channels = channels;
    }
}
