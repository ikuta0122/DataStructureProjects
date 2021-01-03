package com.ikuta.stack;

import java.util.Iterator;

//栈的底层实现既可以是数组,也可以是链表[本处采用链表]
public class Stack<T> implements Iterable<T> {
    //记录首结点
    private Node head;
    //栈中元素的个数
    private int N;

    //内部结点类
    private class Node {
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public Stack() {
        this.head = new Node(null, null);
        this.N = 0;
    }

    //方法:判断当前栈中元素是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    //方法:获取栈中元素个数
    public int size() {
        return N;
    }

    //方法:压栈
    public void push(T t) {
        //1.获取原栈顶结点
        Node oldFirst = head.next;
        //2.创建新结点[数据域存储元素t,指针域指向原栈顶结点]
        Node newNode = new Node(t, oldFirst);
        //3.首结点指向新结点
        head.next = newNode;
        //4.元素个数加1
        N++;
    }

    //方法:弹栈
    public T pop() {
        //1.获取原栈顶结点
        Node oldFirst = head.next;
        //2.判断是否栈中元素是否为空[安全性校验]
        if (oldFirst == null) {
            return null;
        }
        //2.首结点指向原栈顶结点的下一个结点
        head.next = oldFirst.next;
        //3.元素个数减1；
        N--;
        //4.弹出原栈顶结点
        return oldFirst.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator {
        private Node n;

        public SIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }

}
