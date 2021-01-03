package com.ikuta.symboltable;

public class SymbolTable<Key, Value> {
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

    public SymbolTable() {
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    //方法:获取符号表的键值对个数
    public int size() {
        return N;
    }

    //方法:插入键值对
    public void put(Key key, Value value) {
        //1.符号表中key已存在:通过遍历符号表找到同名key,替换其value
        Node n = head;
        while (n.next != null) {
            n = n.next;
            if (n.key.equals(key)) {
                n.value = value;
                return;
            }
        }
        //2.如果符号表中key不存在:创建新结点[指针域指向原首结点]
        //2.1获取原首结点
        Node oldFirst = head.next;
        //2.2创建新结点
        Node newFirst = new Node(key, value, oldFirst);
        //2.3设置新首结点
        head.next = newFirst;
        //2.4元素个数+1；
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
