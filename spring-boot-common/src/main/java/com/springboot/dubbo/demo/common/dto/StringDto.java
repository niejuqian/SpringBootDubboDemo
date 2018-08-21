package com.springboot.dubbo.demo.common.dto;

/**
 * 返回支字符串
 * Created by 6213 on 2018/4/25.
 */
public class StringDto extends Dto {
    private String result;

    public StringDto() {
    }

    public StringDto(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public static StringDto build(String result) {
        return new StringDto(result);
    }
}
