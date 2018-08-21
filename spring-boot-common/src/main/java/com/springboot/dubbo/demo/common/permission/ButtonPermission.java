package com.springboot.dubbo.demo.common.permission;

/**
 * 按钮权限
 * Created by Benson on 2018/4/9.
 */
public class ButtonPermission {

    private String code;

    private String name;

    public ButtonPermission(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
