package com.springboot.dubbo.demo.war.datastructure;

import java.util.AbstractList;

/**
 * 单向链表
 * Created by laonie on 2018/9/6.
 */
public class SingleLinkedList<E> extends AbstractList<E>{
    private Node<E> first;
    private int size;

    @Override
    public E get(int index) {
        checkElementIndex(index);
        return node(index).data;
    }

    Node<E> node(int index) {
        int cursorTmp = 0;
        if (cursorTmp == index) {
            return this.first;
        }
        Node<E> tmp = this.first;
        while (tmp != null) {
            if (cursorTmp == index) {
                return tmp;
            }
            tmp = tmp.next;
            cursorTmp++;
        }
        return null;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private static class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> pre;

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPre() {
            return pre;
        }

        public void setPre(Node<E> pre) {
            this.pre = pre;
        }
    }

    public Node<E> addNode(E data) {
        Node<E> newNode = new Node<>(data);
        if (size == 0) {
            this.first = newNode;
        } else {
            this.first.pre = newNode;
            newNode.next = this.first;
            this.first = newNode;
        }
        size ++;
        return newNode;
    }

    public Node<E> getNode(E data) {
        if (this.first == null) {
            return null;
        }
        Node<E> tmpNode = this.first;
        while (tmpNode != null) {
            if (tmpNode.data.equals(data)) {
                return tmpNode;
            }
            tmpNode = tmpNode.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void display(){
        if (isEmpty()) {
            System.out.println(" this linkedlist is empty");
            return;
        }
        Node<E> dispNode = this.first;
        while (dispNode != null) {
            Node<E> dispPre = dispNode.pre;
            Node<E> dispNext = dispNode.next;
            E preData = null != dispPre ? dispPre.data : null;
            E nextData = null != dispNext ? dispNext.data : null;
            System.out.println("pre=" + preData + ",data=" + dispNode.data + ",next=" + nextData);
            dispNode = dispNode.next;
            System.out.println();
        }
    }

}
