package com.ikuta.linklist.reverse;

import java.util.Iterator;

public class LinkList<T> implements Iterable<T> {
    //记录头结点
    private Node head;
    //记录链表的长度
    private int N;

    private class Node {
        //存储数据
        T item;
        //下一个结点
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    //构造方法
    public LinkList() {
        //初始化头结点
        this.head = new Node(null, null);
        //初始化元素个数
        this.N = 0;
    }

    //方法:清空链表
    public void clear() {
        head.next = null;
        N = 0;
    }

    //方法:判断链表是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    //方法:获取链表的长度
    public int length() {
        return N;
    }

    //方法:获取指定位置i处的元素
    public T get(int i) {
        //通过循环,从头结点开始往后找i次
        Node n = head.next;
        for (int index = 0; index < i; index++) {
            n = n.next;
        }
        return n.item;
    }

    //方法:向链表中添加元素t
    public void insert(T t) {
        //1.创建新结点保存元素t
        Node newNode = new Node(t, null);
        //2.找到尾结点
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        //3.尾结点指向元素t
        n.next = newNode;
        //4.元素个数加1
        N++;
    }

    //方法:向指定位置i处添加元素t
    public void insert(int i, T t) {
        //1.创建新结点保存元素t
        Node newNode = new Node(t, null);
        //2.获取原i-1处的元素
        Node pre = head;
        for (int index = 0; index <= i - 1; index++) {
            pre = pre.next;
        }
        //3.获取原i处的元素
        Node curr = pre.next;
        //4.原i-1处的元素指向新结点
        pre.next = newNode;
        //5.新结点指向原i处的结点
        newNode.next = curr;
        //6.元素个数+1
        N++;
    }

    //方法:删除指定位置i处的元素,并返回被删除的元素
    public T remove(int i) {
        //0.安全性检验
        if (i >= N) {
            return null;
        }
        //1.1获取原i-1处的元素
        Node preNode = head;
        for (int index = 0; index <= i - 1; index++) {
            preNode = preNode.next;
        }
        //1.2获取原i处的元素
        Node currNode = preNode.next;
        //1.3获取原i+1处的元素
        Node nextNode = currNode.next;
        //2.1将原i-1处的元素指向原i+1处
        preNode.next = nextNode;
        //2.2将原i处的元素的指针域设置为null[可以不设置]
        currNode.next = null;
        //3.元素个数减1
        N--;
        return currNode.item;
    }

    //方法:查找元素t在链表中第一次出现的位置
    public int indexOf(T t) {
        Node n = head;
        for (int index = 0; n.next != null; index++) {
            n = n.next;
            if (n.item.equals(t)) {
                return index;
            }
        }
        return -1;
    }

    //单向链表的遍历
    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator {
        private Node n;

        public LIterator() {
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

    //方法:反转整个链表
    public void reverse() {
        //0.判断链表是否为空
        if (isEmpty()){
            return;
        }
        //1.反转指定结点
        reverse(head.next);
    }

    //方法:反转指定结点并返回
    public Node reverse(Node oldNode) {
        //0.设置递归结束条件
        if (oldNode.next == null){
            head.next = oldNode;
            return oldNode;
        }
        //1.递归反转下一个结点
        Node newNode = reverse(oldNode.next);
        //2.设置preNode的指针域指向当前结点
        newNode.next = oldNode;
        //3.设置当前结点的指针域为null
        oldNode.next = null;
        return oldNode;
    }
}
