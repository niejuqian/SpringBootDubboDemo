package com.springboot.dubbo.demo.war.designpattern.Strategy;

import com.springboot.dubbo.demo.war.designpattern.Strategy.bean.PayInfo;
import com.springboot.dubbo.demo.war.designpattern.Strategy.enums.PayChannel;
import com.springboot.dubbo.demo.war.designpattern.Strategy.service.PayService;
import com.springboot.dubbo.demo.war.designpattern.Strategy.service.PayServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by laonie on 2018/9/12.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        PayInfo info = new PayInfo();
        info.setOrderId("dfdsfdfdfdsfdfd");
        info.setPayAmount(new BigDecimal("100"));
        List<PayChannel> channels = new ArrayList<>();
        channels.add(PayChannel.POINT);
        channels.add(PayChannel.BALANCE);
        channels.add(PayChannel.WX_APP);
        info.setChannels(channels);
        PayService payService = new PayServiceImpl();
        payService.doPay(info);
    }
}
