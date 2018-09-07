package com.springboot.dubbo.demo.war.arithmetic;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by laonie on 2018/9/3.
 */
public class Test {
    static Random random = new Random();
    static int initialCapacity = 100000;
    public static boolean exists(int val,int[] arrs) {
        if (arrs.length == 0) return false;
        for (int i = 0; i < arrs.length; i++) {
            if (val == arrs[i]) {
                return true;
            }
        }
        return false;
    }

    private static int loadVal(int[] arrs) {
        int val = random.nextInt(initialCapacity * 10);
        if (exists(val,arrs)) {
            val = loadVal(arrs);
        }
        return val;
    }

    /**
     * 普通查找
     * @param arrs
     * @param val
     * @return
     */
    public static int find(int[] arrs,int val) {
        for (int i = 0; i < arrs.length; i++) {
            if (val == arrs[i]) {
                return i;
            }
        }
        return -1;
    }


    public static int[] sort(int[] arrs){
        for (int i = 0; i < arrs.length -1; i++) {
            // 内层循环n-1-i
            for (int j = 0; j < arrs.length - 1 - i; j++) {
                if (arrs[j] > arrs[j + 1]) {
                    int temp = arrs[j];
                    arrs[j] = arrs[j + 1];
                    arrs[j + 1] = temp;
                }
            }
        }
        return arrs;
    }


    public static void main(String[] args) {
        int init = -5;
        System.out.println(init >>> 1);
        System.out.println(init >> 1);

        /*int[] arrs = new int[initialCapacity];
        for (int i = 0; i < initialCapacity; i++) {
            int val = loadVal(arrs);
            arrs[i] = val;
        }

        int randomPosition = random.nextInt(initialCapacity);
        int randomVal = arrs[randomPosition];
        int[] tmpArrs = Arrays.copyOfRange(arrs,0,arrs.length);
        System.out.println("随机查找下标为：" + randomPosition + "，值为：" + randomVal);
        System.out.println("现在开始通过以下几种方式查看查找耗时");
        long start = System.currentTimeMillis();
        System.out.println("---------------普通查找----------------");
        sort(tmpArrs);
        System.out.println("排序耗时：" + (System.currentTimeMillis() - start));
        int normalFindPosition = find(tmpArrs,randomVal);
        System.out.println("普通查找耗时：" + (System.currentTimeMillis() - start) + "，下标为：" + normalFindPosition);

        start = System.currentTimeMillis();
        System.out.println("---------------快速排序+二分查找----------------");
        QuickSort.quickSort(arrs,0,arrs.length - 1);
        System.out.println("排序耗时：" + (System.currentTimeMillis() - start));
        int otherFindPosition = BinaryChop.binaryByWhile(arrs,randomVal);
        System.out.println("快速排序+二分查找耗时：" + (System.currentTimeMillis() - start) + "，下标为：" + otherFindPosition);*/


        //LinkedList<Integer> linkedList = new LinkedList<>();


        /*int i = 5;
        System.out.println(18 >>> 1);
        System.out.println(1 << 7);
        System.out.println(3 & 4);
        System.out.println(i<<1);
        System.out.println(i>>1);
        System.out.println(i / 2);
        System.out.println(i % 2);
        System.out.println("1 << 2=" + (6 << 3));

        String s1 = "s1";
        String s2 = s1;
        System.out.println(s1 == s2);
        s1 = new String(s2);
        System.out.println(s1 == s2);
        System.out.println(s1 + "--" + s2);

        Integer i1 = 2;
        Integer i2 = 2;
        System.out.println(i1 == i2);
        i1 = 128;
        i2 = 128;
        System.out.println(i1 == i2);

        Hashtable dictionary = new Hashtable();
        dictionary.put();

        int intitalCapacity = 100;
        ConcurrentHashMap<String,Integer> concurrentHashMap = new ConcurrentHashMap<>(intitalCapacity);
        concurrentHashMap.put("name",18);

        HashMap<String,Integer> hashMap = new HashMap<>(intitalCapacity);
        hashMap.put("name",18);

        TreeMap<String,Integer> treeMap = new TreeMap<>();
        Collections.synchronizedSortedMap(new TreeMap<>());

        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();*/
    }
}
