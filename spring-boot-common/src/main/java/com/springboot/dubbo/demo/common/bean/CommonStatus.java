package com.springboot.dubbo.demo.common.bean;

/**
 * 基础状态
 * Created by Benson on 2018/3/7.
 */
public class CommonStatus extends JpaProperty {

    public static final CommonStatus COMMON = newInstance(CommonStatus.class, 10, "正常");

    public static final CommonStatus DISABLED = newInstance(CommonStatus.class, -10, "停用");

}
