package com.ikuta.linklist.joseph;

//约瑟夫问题
public class TestJoseph {
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

    public static void main(String[] args) {
        //1.构建循环链表[包含41个结点,分别存储1~41之间的值]
        Node<Integer> first = null;//记录首结点
        Node<Integer> pre = null;//记录前一个结点
        for (int i = 1; i <= 41; i++) {
            //1.1第一个结点
            if (i == 1) {
                first = new Node<>(i, null);
                pre = first;
                continue;
            }
            //1.2其他结点
            Node<Integer> newNode = new Node<>(i, null);
            pre.next = newNode;
            pre = newNode;
            //1.3形成循环链表
            if (i == 41) {
                pre.next = first;
            }
        }

        //2.声明count计数器[模拟报数]
        int count = 0;

        //3.遍历循环链表
        Node<Integer> currNode = first;//记录遍历指向的当前结点[默认从首结点开始]
        Node<Integer> preNode = null;//记录当前结点的前一个结点
        //结束循环条件:形成自环[结点指向自身]
        while (currNode != currNode.next) {
            //模拟报数
            count++;
            //判断当前报数是不是为3
            if (count == 3) {
                //删除并打印当前结点
                preNode.next = currNode.next;
                System.out.print(currNode.item + " ");
                //当前结点后移
                currNode = currNode.next;
                //重置报数器
                count = 0;
            } else {
                //保留当前结点并后移
                preNode = currNode;
                currNode = currNode.next;
            }
        }
        //打印最后一个元素
        System.out.println();
        System.out.println("最后一个元素 : " + currNode.item);
    }
}
