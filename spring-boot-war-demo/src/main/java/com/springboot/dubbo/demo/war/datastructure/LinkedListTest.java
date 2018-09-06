package com.springboot.dubbo.demo.war.datastructure;

import java.util.Iterator;

/**
 * Created by laonie on 2018/9/6.
 */
public class LinkedListTest {
    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        System.out.println("size=" + linkedList.size());
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);
        linkedList.addNode(5);
        System.out.println("size=" + linkedList.size());
        linkedList.display();
        System.out.println(linkedList.get(2));
        /*LinkedList<Integer> linkedList1 = new LinkedList<>();
        linkedList1.iterator();*/
        Iterator<Integer> ite = linkedList.iterator();
        while (ite.hasNext()) {
            Integer next = ite.next();
            System.out.println(next);
        }
    }
}
