package com.springboot.dubbo.demo.common.util;


import com.google.common.collect.Maps;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BeanUtil {
    @SuppressWarnings("unchecked")
    /**
     * 通过json进行深拷贝
     */
    public static <T> T deepCopy(T obj) {
        if (obj == null) {
            return null;
        }
        return (T) JsonUtil.jsonToBean(JsonUtil.beanToJson(obj), obj.getClass());
    }

    public static <T> List<T> deepCopyList(List<T> obj,Class<T> clazz) {
        if (obj == null) {
            return null;
        }
        return JsonUtil.jsonToList(JsonUtil.beanToJson(obj), clazz);
    }

    @SuppressWarnings("unchecked")
    /**
     * 通过json进行深拷贝
     */
    public static <T> T deepCopy(Object obj,Class<T> clazz) {
        if (obj == null) {
            return null;
        }
        return (T) JsonUtil.jsonToBean(JsonUtil.beanToJson(obj), clazz);
    }

    /**
     * 对象转换为map，如果对象属性值为null,统一转换为空字符串
     * @param obj
     * @return
     */
    public static Map<String, Object> convertBeanToMap(Object obj) {
        if(Objects.isNull(obj)) {
            return null;
        }
        Map<String, Object> map = Maps.newHashMap();
        Class type = obj.getClass();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(type);
            PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor descriptor : propertyDescriptors) {
                String propertyName = descriptor.getName();
                if (!propertyName.equals("class")) {
                    Method readMethod = descriptor.getReadMethod();
                    Object result = readMethod.invoke(obj, new Object[0]);
                    if (result != null) {
                        map.put(propertyName, result);
                    } else {
                        map.put(propertyName, "");
                    }
                }
            }
        } catch (Exception e) {
            return map;
        }
        return map;
    }

    /**
     * 对象转换为map，如果对象属性值为null,统一转换为空字符串
     * @param obj
     * @return
     */
    public static Map<String, String> convertBeanToMapString(Object obj) {
        if(Objects.isNull(obj)) {
            return null;
        }
        Map<String, String> map = Maps.newHashMap();
        Class type = obj.getClass();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(type);
            PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor descriptor : propertyDescriptors) {
                String propertyName = descriptor.getName();
                if (!propertyName.equals("class")) {
                    Method readMethod = descriptor.getReadMethod();
                    Object result = readMethod.invoke(obj, new Object[0]);
                    if (result != null) {
                        map.put(propertyName, result.toString());
                    } else {
                        map.put(propertyName, "");
                    }
                }
            }
        } catch (Exception e) {
            return map;
        }
        return map;
    }

    /**
     * 清除map中value值为空的key
     * @param map
     * @return
     */
    public  static Map<String, Object> resetMapEmptyKey(Map<String, Object> map) {
        if(Objects.isNull(map)) {
            return null;
        }
        Map<String, Object> returnMap = Maps.newHashMap();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if(Objects.nonNull(entry.getValue()) && StringUtil.isNotNil(entry.getValue().toString())) {
                returnMap.put(entry.getKey(), entry.getValue());
            }
        }
        return returnMap;
    }
}
