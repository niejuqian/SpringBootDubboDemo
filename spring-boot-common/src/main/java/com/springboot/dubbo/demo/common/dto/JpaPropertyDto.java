package com.springboot.dubbo.demo.common.dto;

/**
 *
 * @author 6213
 * @date 2018/6/26
 */
public class JpaPropertyDto extends Dto {
    private String code;
    private String name;
    private String group;

    public JpaPropertyDto() {
    }

    public JpaPropertyDto(String code, String name, String group) {
        this.code = code;
        this.name = name;
        this.group = group;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
