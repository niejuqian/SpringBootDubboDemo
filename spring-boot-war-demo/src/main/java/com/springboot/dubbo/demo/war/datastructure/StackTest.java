package com.springboot.dubbo.demo.war.datastructure;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by laonie on 2018/9/6.
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.offer(1);
        queue.addFirst(1);
        queue.offerFirst(1);
        queue.peek();
    }
}
