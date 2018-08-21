package com.springboot.dubbo.demo.common.enums;


import com.springboot.dubbo.demo.common.util.StringUtil;

/**
 *
 * @author 二维码内容key
 * @date 2018/7/3
 */
public enum QrcodeKeyEnum {
    OFFLINE_SCAN_AV("OFFLINE_SCAN_AV","线下扫码活动","offlineScanActivityHandler")
    ;

    private String key;
    private String name;
    private String handler;

    QrcodeKeyEnum(String key, String name,String handler) {
        this.key = key;
        this.name = name;
        this.handler = handler;
    }


    public static QrcodeKeyEnum getEnumByKey(String key) {
        if (StringUtil.isBlank(key)) {
            return null;
        }
        for (QrcodeKeyEnum keyEnum : values()) {
            if (key.equals(keyEnum.getKey())) {
                return keyEnum;
            }
        }
        return null;
    }


    public String getKey() {
        return key;
    }


    public String getName() {
        return name;
    }

    public String getHandler() {
        return handler;
    }
}
