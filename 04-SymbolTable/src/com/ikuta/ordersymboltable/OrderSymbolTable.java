package com.ikuta.ordersymboltable;

public class OrderSymbolTable<Key extends Comparable<Key>, Value> {
    //内部结点类
    private class Node {
        //键
        public Key key;
        //值
        public Value value;
        //下一个结点
        public Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    //记录首结点
    private Node head;
    //记录符号表中元素的个数
    private int N;

    public OrderSymbolTable() {
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    //方法:获取符号表的键值对个数
    public int size() {
        return N;
    }

    //方法:插入键值对
    public void put(Key key, Value value) {
        //1.定义两个Node变量
        Node currNode = head.next;//记录当前结点
        Node preNode = head;//记录上一个结点
        //2.设置key的比较规则[从小到大],通过遍历序号表寻找等于或者大于待插入键值对的key的结点
        while (currNode != null && key.compareTo(currNode.key) > 0) {
            preNode = currNode;
            currNode = currNode.next;
        }
        //3.1寻找到等于待插入键值对的key的结点时,替换其value同时结束方法
        if (currNode != null && key.compareTo(currNode.key) == 0) {
            currNode.value = value;
            return;
        }
        //3.2寻找到大于待插入键值对的key的结点或者寻找不到时,创建新结点
        Node newNode = new Node(key, value, null);
        preNode.next = newNode;
        newNode.next = currNode;
        //3.3元素个数加1；
        N++;
    }

    //方法:删除指定key的键值对
    public void delete(Key key) {
        //1.遍历符号表寻找指定key的键值对
        Node n = head;
        while (n.next != null) {
            //2.判断当前结点A的下一个结点B的键是否为key[删除符合条件的结点B]
            if (n.next.key.equals(key)) {
                n.next = n.next.next;
                N--;
                return;
            }
            //3.继续下一次循环
            n = n.next;
        }
    }

    //方法:获取指定key的键值对的value
    public Value get(Key key) {
        //1.遍历符号表寻找指定key的键值对
        Node n = head;
        while (n.next != null) {
            //2.1继续下一次循环
            n = n.next;
            //2.2当寻找到指定key的键值对时,返回其value
            if (n.key.equals(key)) {
                return n.value;
            }
        }
        //3.循环结束表示符号表中不存在该key的键值对,返回null
        return null;
    }
}
