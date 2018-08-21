package com.springboot.dubbo.demo.common.util;

import com.google.common.collect.Lists;
import com.springboot.dubbo.demo.common.bean.SimpleProperty;
import com.springboot.dubbo.demo.common.dto.SimpleDto;

import java.util.List;

/**
 * 属性帮助类
 *
 * @author 6213
 * @date 2018/4/19
 */
public class JpaPropertyUtil {

    public static List<SimpleDto> getPropertyList(Class<? extends SimpleProperty> clazz){
        List<SimpleDto> dtos = Lists.newArrayList();
        List<SimpleProperty> list = SimpleProperty.getPropertyList(clazz);
        if (CollectionUtil.isNotNil(list)) {
            for (SimpleProperty property : list) {
                dtos.add(new SimpleDto(property.getCode().toString(),property.getName()));
            }
        }
        return dtos;
    }

    public static SimpleDto convertToDto(SimpleProperty property) {
        if (null != property) {
            return new SimpleDto(property.getCode().toString(),property.getName());
        }
        return null;
    }

    public static <T extends SimpleProperty> T convertToProperty(SimpleDto dto,Class<T> clazz) {
        return SimpleProperty.getProperty(clazz,dto.getId());
    }

    public static <T extends SimpleProperty> T convertToProperty(Object code,Class<T> clazz) {
        return SimpleProperty.getProperty(clazz,code);
    }

    public static <T extends SimpleProperty> List<T> convertToPropertys(List<String> codes,Class<T> clazz){
        List<T> result = Lists.newArrayList();
        if (CollectionUtil.isNil(codes)) return result;
        for (String code : codes) {
            result.add(convertToProperty(code,clazz));
        }
        return result;
    }
}
