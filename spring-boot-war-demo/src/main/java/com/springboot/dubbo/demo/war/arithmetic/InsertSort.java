package com.springboot.dubbo.demo.war.arithmetic;

import static com.springboot.dubbo.demo.war.arithmetic.BubbleSort.print;

/**
 * Created by laonie on 2018/9/3.
 */
public class InsertSort {
    public static void sort(int[] arrs) {
        int j = 0;
        for (int i = 1; i < arrs.length; i++) {
            int tmp = arrs[i];
            j = i;
            while (j > 0 && tmp < arrs[j -1] ) {
                arrs[j] = arrs[j-1];
                j--;
            }
            arrs[j] = tmp;
            print("第" + i + "次循环",arrs);
        }
    }

    public static void main(String[] args) {
        int[] arrs = {6,3,8,2,9,1};
        System.out.println("数组长度：" + arrs.length);
        print("原数组",arrs);
        sort(arrs);
        print("排序后",arrs);
    }
}
