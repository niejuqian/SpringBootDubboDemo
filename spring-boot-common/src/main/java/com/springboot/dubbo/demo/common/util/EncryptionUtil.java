package com.springboot.dubbo.demo.common.util;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

/**
 * 加密工具
 * Created by Benson on 2018/3/28.
 */
public class EncryptionUtil {

    // 密码前缀
    private static final String PREFIX_CODE = "^&^$%^$^FTFY233fs";

    public static String sha1(String string) {
        return Hashing.sha1().hashString(string, Charsets.UTF_8).toString();
    }

    public static String md5(String string) {
        return Hashing.md5().hashString(string, Charsets.UTF_8).toString();
    }


    /**
     * 密码加密
     * 首先进行SHA1 安全哈希算法，然后拼装加前缀码，最后进行MD5，即：md5(prefixCode+sha1)
     * @param pwd 需加密的字符串
     * @return 加密后的字符串
     */
    public static String encryptPassword(String pwd) {
        String secret = PREFIX_CODE + sha1(pwd);
        return md5(secret);
    }


    /**
     * 根据盐值加密
     * 首先进行SHA1 安全哈希算法，然后以盐值为前缀进行拼装，最后进行MD5，即：md5(saltValue+sha1)
     * @param pwd 明文密码串
     * @param saltValue 盐值
     * @return 加密后的字符串
     */
    public static String encryptBySalt(String pwd, String saltValue) {
        String secret = saltValue + sha1(pwd);
        return md5(secret);
    }

}
