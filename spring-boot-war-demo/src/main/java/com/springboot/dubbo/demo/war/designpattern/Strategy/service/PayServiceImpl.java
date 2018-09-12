package com.springboot.dubbo.demo.war.designpattern.Strategy.service;

import com.springboot.dubbo.demo.war.designpattern.Strategy.bean.PayInfo;
import com.springboot.dubbo.demo.war.designpattern.Strategy.enums.PayChannel;
import com.springboot.dubbo.demo.war.designpattern.Strategy.pay.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by laonie on 2018/9/12.
 */
public class PayServiceImpl implements PayService {

    @Override
    public void doPay(PayInfo info) throws Exception {
        System.out.println("start doPay order ...");

        // 验证支付参数是否合法
        System.out.println("验证支付参数是否合法");
        // 验证订单支付金额是否正确
        System.out.println("验证订单支付金额是否正确");
        // 开始进行支付
        // 订单剩余支付金额（这里跟传入金额保持一致）
        BigDecimal orderSurplusAmount = info.getPayAmount();
        List<PayChannel> channels = info.getChannels();
        for (PayChannel channel : channels) {
            System.out.println("订单总剩余支付金额：" + orderSurplusAmount.toPlainString());
            IPay pay = PayFactory.createPayProxy(channel);
            if (null == pay) {
                throw new NullPointerException("pay channel is Null");
            }
            BigDecimal payAmount = pay.doPay(info.getOrderId(),orderSurplusAmount);
            orderSurplusAmount = orderSurplusAmount.subtract(payAmount);
            if (orderSurplusAmount.compareTo(BigDecimal.ZERO) <= 0) {
                System.out.println("订单已经支付完毕，不用再继续支付");
                break;
            }
        }
        // 如果支付完毕，更改订单支付状态
        System.out.println("doPay finish.");
    }

    private static class PayFactory {
        public static IPay createPayProxy(PayChannel channel){
            if (channel == PayChannel.POINT) {
                return new PointPayImpl();
            }
            if (channel == PayChannel.BALANCE) {
                return new BalancePayImpl();
            }
            if (channel == PayChannel.WX_APP || channel == PayChannel.WX_WAP) {
                AbstractWxPay wxPay = null;
                if (channel == PayChannel.WX_APP) {
                    wxPay = new WxAPPPayImpl();
                }
                return wxPay;
            }
            return null;
        }
    }
}
