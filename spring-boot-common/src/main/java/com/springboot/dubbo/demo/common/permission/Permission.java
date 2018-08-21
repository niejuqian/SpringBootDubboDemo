package com.springboot.dubbo.demo.common.permission;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;

public class Permission implements Serializable {

    private String code;

    private String name;

    private List<ButtonPermission> buttonPermissions;

    public Permission(String code, String name) {
        this.code = code;
        this.name = name;
        this.buttonPermissions = Lists.newArrayList();
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public List<ButtonPermission> getButtonPermissions() {
        return buttonPermissions;
    }

    /**
     * 添加按钮权限
     * @param buttonPermission
     */
    public void addButtonPermission(ButtonPermission buttonPermission) {
        buttonPermissions.add(buttonPermission);
    }

}
