package com.springboot.dubbo.demo.war.arithmetic;

import static com.springboot.dubbo.demo.war.arithmetic.BubbleSort.print;

/**
 * 选择排序
 * Created by laonie on 2018/9/3.
 */
public class ChoiseSort {

    public static void main(String[] args) {
        int[] arrs = {6,3,8,2,9,1};
        System.out.println("数组长度：" + arrs.length);
        print("原数组",arrs);
        sort(arrs);
        print("排序后",arrs);
    }

    /**
     * 选择排序
     * @param arrs
     */
    public static void sort(int[] arrs){
        for (int i = 0; i < arrs.length -1; i++) {
            int min = i;
            for (int j = i + 1; j < arrs.length; j++) {
                if (arrs[j] < arrs[min]) {
                    min = j; // 找到较小元素下标
                }
            }
            // 如果i != min，则说明找到了一个比i元素小的值
            if (min != i) {
                // 进行元素位置交换
                int temp = arrs[i];
                arrs[i] = arrs[min];
                arrs[min] = temp;
            }
            print("第" + (i + 1) + "次循环",arrs);
        }
    }
}
