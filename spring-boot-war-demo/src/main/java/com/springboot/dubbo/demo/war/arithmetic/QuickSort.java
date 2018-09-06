package com.springboot.dubbo.demo.war.arithmetic;

/**
 * 快速排序
 * Created by laonie on 2018/9/6.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arrs = {11,3,6,8,20,19};
        BubbleSort.print("排序前",arrs);
        //getMiddle(arrs,0,arrs.length-1);
        //BubbleSort.print("第一轮",arrs);
        quickSort(arrs,0,arrs.length-1);
        //BubbleSort.print("快速排序",arrs);
    }

    public static void quickSort(int[] arrs,int low,int hight) {
        if (low < hight) {
            int middle = getMiddle(arrs,low,hight);
            quickSort(arrs,low,middle - 1);
            quickSort(arrs,middle + 1,hight);
        }
    }

    public static int getMiddle(int[] arrs,int low,int high) {
        int temp = arrs[low];
        while (low < high) {
            while (low < high && arrs[high] > temp) {
                high --;
            }
            arrs[low] = arrs[high];

            while (low < high && arrs[low] < temp) {
                low++;
            }
            arrs[high] = arrs[low];
        }
        arrs[low] = temp;
        System.out.println("middle=" + temp);
        BubbleSort.print("快速排序",arrs);
        return low;
    }
}
