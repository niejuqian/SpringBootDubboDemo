package com.springboot.dubbo.demo.war.arithmetic;

/**
 * 冒泡排序
 * Created by laonie on 2018/9/2.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arrs = {6,3,8,2,9,1};
        System.out.println("数组长度：" + arrs.length);
        print("原数组",arrs);
        // 进行冒泡排序
        // 外层循环n-1
        for (int i = 0; i < arrs.length -1; i++) {
            // 内层循环n-1-i
            for (int j = 0; j < arrs.length - 1 - i; j++) {
                if (arrs[j] > arrs[j + 1]) {
                    int temp = arrs[j];
                    arrs[j] = arrs[j + 1];
                    arrs[j + 1] = temp;
                }
            }
            print("第" + (i + 1) + "次循环",arrs);
        }
        print("排序后",arrs);
    }

    public static void print(String name,int[] arrs){
        System.out.print(name + "：");
        for (int i = 0; i < arrs.length; i++) {
            System.out.print(arrs[i] + " ");
        }
        System.out.println();
    }
}
