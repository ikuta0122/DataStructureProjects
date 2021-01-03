package com.ikuta.linklist.speedpointer;

//Test01链表的中间值问题
public class Test01 {
    //结点类
    private static class Node<T> {
        //存储数据
        T item;
        //下一个结点
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public static void main(String[] args) throws Exception {
        //创建结点
        Node<String> first = new Node<String>("aa", null);
        Node<String> second = new Node<String>("bb", null);
        Node<String> third = new Node<String>("cc", null);
        Node<String> fourth = new Node<String>("dd", null);
        Node<String> fifth = new Node<String>("ee", null);
        Node<String> six = new Node<String>("ff", null);
        Node<String> seven = new Node<String>("gg", null);
        Node<String> eight = new Node<String>("hh", null);

        //完成结点之间的指向
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = seven;
        seven.next = eight;

        //查找中间值
        String mid = getMid(first);
        System.out.println("中间值为：" + mid);
    }

    /**
     * @param first 链表的首结点
     * @return 链表的中间结点的值
     */
    public static String getMid(Node<String> first) {
        //定义两个指针
        Node<String> fast = first;
        Node<String> slow = first;
        // 使用两个指针遍历链表
        // 思路1:快指针一次走两步,慢指针一次走一步
        // 思路2:当链表长度为奇数时,结束条件为fast.next == null
        // 思路3:当链表长度为偶数时,结束条件为fast == null
        while (fast.next != null && fast != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow.item;
    }
}
