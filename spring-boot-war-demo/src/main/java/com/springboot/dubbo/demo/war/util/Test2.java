package com.springboot.dubbo.demo.war.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 初始容量不是越大越好，最好的定义是按照自己的需求来，一般来说，默认容量已经能够了。
 * 要搞懂这个问题，首先要知道ArrayList扩容，ArrayList的扩容基数是初始容量 + 初始容量/2
 * 如果你初始容量很大，也会导致最后一次扩容后的数组容量非常庞大，则更加消耗资源
 * <p>
 *  扩容公式：n + n/2
 *  初始容量	    第一次	第二次	第三次	第四次	第五次
 *    10		  15      22      33      49      73
 *    1000      1500    2250    3375    5062    7593
 * </p>
 * Created by laonie on 2018/9/16.
 */
public class Test2 {
    public static void main(String[] args) {
        long initCapacity = 1000;
        long growCount = 20;
        long endCapacity = grow(growCount,initCapacity);
        System.out.println("初始容量：" + initCapacity + "，经过：" + growCount + "次扩容后，最终容量为：" + endCapacity);
        /*List<Object> obj1 = new ArrayList<>();
        List<Object> obj2 = new ArrayList<>(300);
        int len = 1000000;
        long start = System.currentTimeMillis();
        for (int i = 0; i < len; i++) {
            obj1.add(new Object());
        }
        System.out.println("默认容量，耗时：" + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < len; i++) {
            obj2.add(new Object());
        }
        System.out.println("默认500容量，耗时：" + (System.currentTimeMillis() - start));*/
    }

    public static long grow(long count,long capacity) {
        if (count > 0) {
            capacity = capacity + (capacity / 2);
            System.out.println("count=" + count + "，capacity=" + capacity);
            capacity = grow(--count,capacity);
        }
        return capacity;
    }
}
