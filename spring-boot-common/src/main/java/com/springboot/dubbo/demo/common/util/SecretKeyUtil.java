package com.springboot.dubbo.demo.common.util;

/**
 * 秘钥工具类
 * Created by Benson on 2018/3/29.
 */
public class SecretKeyUtil {

    public static final String PREFIX = "S#U%C&C!E^S*S";

    /**
     * 生成加密秘钥
     * 规则：前缀+秘钥主体内容
     * @param key 秘钥主体内容
     * @return
     */
    public static String generate(String key) {
        String secret = PREFIX + key;
        return EncryptionUtil.md5(secret);
    }

}
