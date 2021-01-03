package com.ikuta.AI.undirectedgraph;

import java.util.Iterator;

//此处队列作为邻接表用于完成无向图的实现
public class Queue<T> implements Iterable<T> {
    //记录首结点
    private Node head;
    //记录尾结点
    private Node last;
    //记录队列的元素个数
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

    public Queue() {
        this.head = new Node(null, null);
        this.last = null;
        this.N = 0;
    }

    //方法:判断队列是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    //方法:返回队列的元素个数
    public int size() {
        return N;
    }

    //方法:入队
    public void enqueue(T t) {
        //1.获取原尾结点
        Node oldLast = last == null ? head : last;
        //2.创建新尾结点
        Node newLast = new Node(t, null);
        //3.设置新尾结点
        last = newLast;
        //4.原尾结点的指针域指向新尾结点
        oldLast.next = last;
        //5.元素个数加1
        N++;
    }

    //方法:出队
    public T dequeue() {
        //0.安全性检验
        if (isEmpty()) {
            return null;
        }
        //1.获取原首结点
        Node oldFirst = head.next;
        //2.设置新首结点
        head.next = oldFirst.next;
        //3.元素个数减1
        N--;
        //4.当队列为空时,重置尾结点
        if (isEmpty()) {
            last = null;
        }
        //5.返回原首结点的数据域
        return oldFirst.item;
    }


    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }

    private class QIterator implements Iterator {
        private Node n;

        public QIterator() {
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