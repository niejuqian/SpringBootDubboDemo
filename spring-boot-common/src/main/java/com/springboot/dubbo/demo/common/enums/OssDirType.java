package com.springboot.dubbo.demo.common.enums;

/**
 * OSS 目录枚举
 * Created by Benson on 2018/6/1.
 */
public enum OssDirType {

    FILE("file", "普通文件存储目录"),
    ZIP_FILE("zipFile", "游戏版本zip包存储目录");

    private String dir;     // 目录
    private String desc;    // 描述

    OssDirType(String dir, String desc) {
        this.dir = dir;
        this.desc = desc;
    }

    public String getDir() {
        return dir;
    }

    public String getDesc() {
        return desc;
    }
}
