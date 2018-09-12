package com.springboot.dubbo.demo.war.designpattern.Strategy.enums;

/**
 * Created by laonie on 2018/9/12.
 */
public enum PayChannel {
    POINT("POINT","使用积分支付","内部支付"),
    BALANCE("BALANCE","使用余额账户支付","内部支付"),
    ZFB_APP("ZFB_APP","使用支付宝APP支付","第三方支付"),
    WX_APP("WX_APP","使用微信APP支付","第三方支付"),
    WX_WAP("WX_WAP","使用微信WAP支付","第三方支付");

    private String payType;
    private String payTypeDesc;
    private String payChannel;

    PayChannel(String payType, String payTypeDesc, String payChannel) {
        this.payType = payType;
        this.payTypeDesc = payTypeDesc;
        this.payChannel = payChannel;
    }

    public String getPayType() {
        return payType;
    }

    public String getPayTypeDesc() {
        return payTypeDesc;
    }

    public String getPayChannel() {
        return payChannel;
    }
}
