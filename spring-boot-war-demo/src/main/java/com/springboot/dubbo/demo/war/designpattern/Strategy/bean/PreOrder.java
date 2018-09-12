package com.springboot.dubbo.demo.war.designpattern.Strategy.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by laonie on 2018/9/12.
 */
public class PreOrder implements Serializable{
    private String orderId;
    private BigDecimal amount;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
