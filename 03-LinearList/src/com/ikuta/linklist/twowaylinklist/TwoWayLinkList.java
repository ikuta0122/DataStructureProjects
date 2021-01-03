package com.ikuta.linklist.twowaylinklist;

import java.util.Iterator;

public class TwoWayLinkList<T> implements Iterable<T> {
    //首结点
    private Node head;
    //尾结点
    private Node last;
    //链表长度
    private int N;

    //结点类
    private class Node {
        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }

        //存储数据
        public T item;
        //指向上一个结点
        public Node pre;
        //指向下一个结点
        public Node next;
    }

    public TwoWayLinkList() {
        //初始化头结点和尾结点
        this.head = new Node(null, null, null);
        this.last = null;
        //初始化元素个数
        this.N = 0;
    }

    //方法:清空链表
    public void clear() {
        this.head.next = null;
        this.head.pre = null;
        this.head.item = null;
        this.last = null;
        this.N = 0;
    }

    //方法:获取链表长度
    public int length() {
        return N;
    }

    //方法:判断链表是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    //方法:获取第一个元素
    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.next.item;
    }

    //方法:获取最后一个元素
    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return last.item;
    }

    //方法:获取指定位置i处的元素
    public T get(int i) {
        Node n = head.next;
        for (int index = 0; index < i; index++) {
            n = n.next;
        }
        return n.item;
    }

    //方法:找到元素t在链表中第一次出现的位置
    public int indexOf(T t) {
        Node n = head;
        for (int index = 0; n.next != null; index++) {
            n = n.next;
            if (n.next.equals(t)) {
                return index;
            }
        }
        return -1;
    }

    //方法:插入元素t
    public void insert(T t) {
        //1.记录原尾结点[链表为空时,头结点就是尾结点]
        Node oldLast = isEmpty() ? head : last;
        //2.创建新结点,前驱指针指向原尾结点,后驱指针为null
        Node newNode = new Node(t, oldLast, null);
        //3.新结点成为尾结点
        last = newNode;
        //4.头结点指向尾结点
        oldLast.next = last;
        //5.元素个数+1
        N++;
    }

    //方法:向指定位置i处插入元素t
    public void insert(int i, T t) {
        //1.获取i-1位置的结点
        Node pre = head;
        for (int index = 0; index < i; index++) {
            pre = pre.next;
        }
        //2.获取原i位置的结点
        Node curr = pre.next;
        //3.创建新结点,前驱指针指向i-1处结点,后继指针指向原i处结点
        Node newNode = new Node(t, pre, curr);
        //4.i-1位置结点的后继指针指向新结点
        pre.next = newNode;
        //5.原i位置结点的前驱指针指向新结点
        curr.pre = newNode;
        //6.元素个数+1
        N++;
    }

    //方法:删除位置i处的元素，并返回该元素
    public T remove(int i) {
        //1.1获取i-1位置的结点
        Node pre = head;
        for (int index = 0; index < i; index++) {
            pre = pre.next;
        }
        //1.2获取原i位置的结点
        Node curr = pre.next;
        //1.3获取i+1位置的结点
        Node nextNode = curr.next;
        //2.1原i-1位置结点的后继指针指向原i+1位置结点
        pre.next = nextNode;
        //2.2原i+1位置结点的前驱指针指向原i-1位置结点
        nextNode.pre = pre;
        //3.元素个数减1
        N--;
        //4.返回被删除元素的数据
        return curr.item;
    }

    //双向链表的遍历
    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }

    private class TIterator implements Iterator {
        private Node n;

        public TIterator() {
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
