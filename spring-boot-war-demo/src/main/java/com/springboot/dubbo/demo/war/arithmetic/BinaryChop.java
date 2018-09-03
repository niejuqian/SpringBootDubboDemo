package com.springboot.dubbo.demo.war.arithmetic;

import java.util.Arrays;

/**
 * 二分查找
 * Created by laonie on 2018/9/2.
 */
public class BinaryChop {

    public static void main(String[] args) {
        int[] arrs = {23,15,3,17,78,34,29,135};
        // 首先要进行排序
        Arrays.sort(arrs);
        BubbleSort.print("排序",arrs);
        int key = 34;
        System.out.println("递归查找实现方案：");
        int position = binaryByRecursion(arrs,0,arrs.length - 1,34);
        if (position == -1) {
            System.out.println("未找到值为：" + key + " 在数组中的位置");
        } else {
            System.out.println("查找成功，值：" + key + " 在数组的第：" + (position + 1) + "个位置");
        }
        System.out.println("普通循环实现方案：");
        position = binaryByWhile(arrs,34);
        if (position == -1) {
            System.out.println("未找到值为：" + key + " 在数组中的位置");
        } else {
            System.out.println("查找成功，值：" + key + " 在数组的第：" + (position + 1) + "个位置");
        }
    }

    /**
     * 普通循环实现方法
     * @param arrs
     * @param key
     * @return
     */
    public static int binaryByWhile(int[] arrs,int key){
        int start = 0;
        int end = arrs.length -1;
        int mid = (end - start) / 2;
        int midVal = arrs[mid];
        if (midVal == key) {
            return mid;
        }
        int result = -1;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            midVal = arrs[mid];
            if (midVal == key) {
                result = mid;
                break;
            }
            if (midVal < key) {
                // 大于中值，则在中值后里面在按照二分查找法继续查找，将起始坐标重置为中间点 + 1
                start = mid + 1;
            } else {
                // 小于中值，则在中值前里面在按照二分查找法继续查找，将结束坐标重置为中间点 - 1
                end = mid -1;
            }
        }
        return result;
    }


    /**
     * 递归实现法
     * @param arrs
     * @param start
     * @param end
     * @param key
     * @return
     */
    public static int binaryByRecursion(int[] arrs,int start,int end,int key){
        int mid = (end - start) / 2 + start;
        int midVal = arrs[mid];
        // 等于中值，直接返回
        if (midVal == key) {
            return mid;
        }
        if (midVal < key) {
            // 大于中值，则在中值后里面在按照二分查找法继续查找，将起始坐标重置为中间点 + 1
            return binaryByRecursion(arrs,mid + 1,end,key);
        }
        if (midVal > key) {
            // 小于中值，则在中值前里面在按照二分查找法继续查找，将结束坐标重置为中间点 - 1
            return binaryByRecursion(arrs,start,end -1,key);
        }
        // 返回-1，则说明未查询到
        return -1;
    }
}
