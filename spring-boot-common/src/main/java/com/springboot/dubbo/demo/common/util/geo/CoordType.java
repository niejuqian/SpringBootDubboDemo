package com.springboot.dubbo.demo.common.util.geo;

/**
 * 坐标类型
 *
 * @author 6213
 * @date 2018/7/9
 */
public enum CoordType {

    /**WGS-84 支持厂商:苹果**/
    EARTH("EARTH", "地球坐标"),
    /**GCJ-02 支持厂商:谷歌、高德**/
    MARS("MARS", "火星坐标"),
    /**BD-09  支持厂商:百度**/
    BAIDU("BAIDU", "百度坐标"),
    /**搜狗       支持厂商：搜狗   http://map.sogou.com/api/**/
    SOGOU("SOGOU", "搜狗坐标"),
    /**图吧      支持厂商：图吧  http://open.mapbar.com/**/
    MAPBAR("MAPBAR", "搜狗坐标");

    private String name;
    private String remark;

    CoordType(String name, String remark){
        this.name = name;
        this.remark = remark;
    }

    public static CoordType codeOf(String name) {
        for (CoordType s : CoordType.values()) {
            if (equalsIgnoreCase(s.getName(), name)) {
                return s;
            }
        }

        return null;
    }

    private static boolean equalsIgnoreCase(String str1, String str2)
    {
        return str1 != null ? str1.equalsIgnoreCase(str2) : str2 == null;
    }


    public String getName() {
        return name;
    }

    public String getRemark() {
        return remark;
    }
}
