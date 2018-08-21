package com.springboot.dubbo.demo.common.permission;


import com.springboot.dubbo.demo.common.collection.ArrayHashMap;

import java.io.Serializable;
import java.util.List;

public class PermissionGroup implements Serializable {
    private String code;

    private String name;

    private ArrayHashMap<String, Permission> permissions;

    public PermissionGroup(String code, String name) {
        this.code = code;
        this.name = name;
        this.permissions = ArrayHashMap.newInstance();
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void addPermission(String code, Permission permission) {
        permissions.add(code, permission);
    }

    public Permission getPermission(String code) {
        return permissions.get(code);
    }

    public List<Permission> getPermissions() {
        return permissions.getList();
    }
}
