package com.springboot.dubbo.demo.common.util;

import org.hibernate.id.UUIDHexGenerator;

import java.util.UUID;

/**
 * id生成器
 * @author arjun
 *
 */
public class IdGeneratorUtils {
	
	private static UUIDHexGenerator generator = new UUIDHexGenerator();
	
	public static String getId() {
		return generator.generate(null, null).toString();
	}

	private IdGeneratorUtils() {
	}


	/**
	 * 获取随机字符串 Nonce Str
	 *
	 * @return String 随机字符串
	 */
	public static String generateNonceStr() {
		return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
	}
}
