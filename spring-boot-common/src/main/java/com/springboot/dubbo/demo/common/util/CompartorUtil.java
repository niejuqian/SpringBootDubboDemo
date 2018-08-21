package com.springboot.dubbo.demo.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * 集合排序帮助类
 *
 * @author 6213
 * @date 2018/8/9
 */
public class CompartorUtil {
    private static final Logger logger = LoggerFactory.getLogger(CompartorUtil.class);

    /**
     * 对集合进行分组
     * @param list 原集合
     * @param groupFields 分组字段数组
     * @param <E>
     * @return
     */
    public static <E> Map<String,List<E>> group(List<E> list, String[] groupFields) {
        if (list == null || list.size() == 0 || groupFields == null || groupFields.length == 0) {
            return null;
        }
        Map<String,List<E>> groupMap = new HashMap<>();
        groupMap = list.stream().collect(Collectors.groupingBy(item->{
            try {
                return groupFiledVal(item,groupFields);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }));
        return groupMap;
    }

    private static <E> String groupFiledVal(E item,String[] groupFields) throws Exception {
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < groupFields.length; i++) {
            String fieldName = groupFields[i];
            Object value = forceGetFieldValue(item, fieldName);
            if (null != value) {
                result.append(value);
            }
        }
        return result.toString();
    }

    /**
     * 给list的每个属性都指定是升序还是降序
     *
     * @param list
     * @param sortnameArr  参数数组
     * @param typeArr      每个属性对应的升降序数组， true升序，false降序
     */

    public static <E> void sort(List<E> list, final String[] sortnameArr, final boolean[] typeArr) {
        if (list == null || list.size() == 0 || sortnameArr == null || sortnameArr.length == 0) {
            return;
        }
        if (sortnameArr.length != typeArr.length) {
            logger.info("属性数组元素个数和升降序数组元素个数不相等");
            return;
        }
        Collections.sort(list, (a, b) -> {
            int ret = 0;
            try {
                for (int i = 0; i < sortnameArr.length; i++) {
                    ret = compareObject(sortnameArr[i], typeArr[i], a, b);
                    if (0 != ret) {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return ret;
        });
    }

    /**
     * 对2个对象按照指定属性名称进行排序
     *
     * @param sortname
     *            属性名称
     * @param isAsc
     *            true升序，false降序
     * @param a
     * @param b
     * @return
     * @throws Exception
     */
    private static <E> int compareObject(final String sortname, final boolean isAsc, E a, E b) throws Exception {
        int ret;
        Object value1 = forceGetFieldValue(a, sortname);
        Object value2 = forceGetFieldValue(b, sortname);
        String str1 = value1.toString();
        String str2 = value2.toString();
        if (value1 instanceof Number && value2 instanceof Number) {
            int maxlen = Math.max(str1.length(), str2.length());
            str1 = addZero2Str((Number) value1, maxlen);
            str2 = addZero2Str((Number) value2, maxlen);
        } else if (value1 instanceof Date && value2 instanceof Date) {
            long time1 = ((Date) value1).getTime();
            long time2 = ((Date) value2).getTime();
            int maxlen = Long.toString(Math.max(time1, time2)).length();
            str1 = addZero2Str(time1, maxlen);
            str2 = addZero2Str(time2, maxlen);
        }
        if (isAsc) {
            ret = str1.compareTo(str2);
        } else {
            ret = str2.compareTo(str1);
        }
        return ret;
    }

    /**
     * 给数字对象按照指定长度在左侧补0.
     *
     * 使用案例: addZero2Str(11,4) 返回 "0011", addZero2Str(-18,6)返回 "-000018"
     *
     * @param numObj
     *            数字对象
     * @param length
     *            指定的长度
     * @return
     */
    public static String addZero2Str(Number numObj, int length) {
        NumberFormat nf = NumberFormat.getInstance();
        // 设置是否使用分组
        nf.setGroupingUsed(false);
        // 设置最大整数位数
        nf.setMaximumIntegerDigits(length);
        // 设置最小整数位数
        nf.setMinimumIntegerDigits(length);
        return nf.format(numObj);
    }

    /**
     * 获取指定对象的指定属性值（去除private,protected的限制）
     *
     * @param obj
     *            属性名称所在的对象
     * @param fieldName
     *            属性名称
     * @return
     * @throws Exception
     */
    public static Object forceGetFieldValue(Object obj, String fieldName) throws Exception {
        Field field = getDeclaredField(obj,fieldName);
        if (null == field) {
            return null;
        }
        Object object = null;
        boolean accessible = field.isAccessible();
        if (!accessible) {
            // 如果是private,protected修饰的属性，需要修改为可以访问的
            field.setAccessible(true);
            object = field.get(obj);
            // 还原private,protected属性的访问性质
            field.setAccessible(accessible);
            return object;
        }
        object = field.get(obj);
        return object;
    }

    /**
     * 循环向上转型, 获取对象的 DeclaredField
     * @param object : 子类对象
     * @param fieldName : 父类中的属性名
     * @return 父类中的属性对象
     */

    public static Field getDeclaredField(Object object, String fieldName){
        Field field = null ;
        Class<?> clazz = object.getClass() ;
        for(; clazz != Object.class ; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName) ;
                return field ;
            } catch (Exception e) {
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
                //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了
            }
        }
        return null;
    }

    /*public static void main(String[] args) {
        List<GoodsItem> items = Lists.newArrayList();
        items.add(new GoodsItem("卡牌1","R",true,true));
        items.add(new GoodsItem("卡牌2","S",false,false));
        items.add(new GoodsItem("卡牌3","SS",true,false));
        items.add(new GoodsItem("卡牌4","S",true,true));
        items.add(new GoodsItem("卡牌5","N",false,false));
        items.add(new GoodsItem("卡牌6","S",true,false));
        System.out.println("===============排序前=================");
        System.out.println(JsonUtil.beanToJson(items));
        System.out.println("===============排序后=================");
        String[] sortnameArr1 = new String[]{"goodsRarity","isCollect"};
        boolean[] typeArr1 = new boolean[]{false,true};
        CompartorUtil.sort(items,sortnameArr1,typeArr1);
        System.out.println(JsonUtil.beanToJson(items));
        System.out.println("===============分组=================");
        String[] groupnameArr = new String[]{"isCollect","activationFlag"};
        Map<String,List<GoodsItem>> groupMap = CompartorUtil.group(items,groupnameArr);
        System.out.println(JsonUtil.beanToJson(groupMap));

        System.out.println("===============分组后排序得到最终结果=================");
        // 1.收集未激活的分一组
        String key1 = "truefalse";
        // 2.未收集的分一组
        String key2 = "falsefalse";
        // 3.已经收集且激活的分一组
        String key3 = "truetrue";
        List<GoodsItem> endResults = Lists.newArrayList();
        // 将每个结果集分别按照品质降序排序
        String[] sortnameArr = new String[]{"goodsRarity"};
        boolean[] typeArr = new boolean[]{false};

        List<GoodsItem> truefalseList = groupMap.get(key1);
        if (CollectionUtil.isNotNil(truefalseList)) {
            CompartorUtil.sort(truefalseList,sortnameArr,typeArr);
            endResults.addAll(truefalseList);
        }
        List<GoodsItem> falsefalseList = groupMap.get(key2);
        if (CollectionUtil.isNotNil(falsefalseList)) {
            CompartorUtil.sort(falsefalseList,sortnameArr,typeArr);
            endResults.addAll(falsefalseList);
        }
        List<GoodsItem> truetrueList = groupMap.get(key3);
        if (CollectionUtil.isNotNil(truetrueList)) {
            CompartorUtil.sort(truetrueList,sortnameArr,typeArr);
            endResults.addAll(truetrueList);
        }

        System.out.println(JsonUtil.beanToJson(endResults));
    }*/


    public static class GoodsItem {
        private String name;
        private String goodsRarity;
        private boolean isCollect;
        private boolean activationFlag;

        public GoodsItem() {
        }

        public GoodsItem(String name,String goodsRarity, boolean isCollect,boolean activationFlag) {
            this.name = name;
            this.goodsRarity = goodsRarity;
            this.isCollect = isCollect;
            this.activationFlag = activationFlag;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGoodsRarity() {
            return goodsRarity;
        }

        public void setGoodsRarity(String goodsRarity) {
            this.goodsRarity = goodsRarity;
        }

        public boolean isCollect() {
            return isCollect;
        }

        public void setCollect(boolean collect) {
            isCollect = collect;
        }

        public boolean isActivationFlag() {
            return activationFlag;
        }

        public void setActivationFlag(boolean activationFlag) {
            this.activationFlag = activationFlag;
        }
    }
}
