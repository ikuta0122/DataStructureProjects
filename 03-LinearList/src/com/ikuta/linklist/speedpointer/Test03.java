package com.ikuta.linklist.speedpointer;

//Test03:有环链表的环入口问题
public class Test03 {
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
        Node<String> first = new Node<String>("aa", null);
        Node<String> second = new Node<String>("bb", null);
        Node<String> third = new Node<String>("cc", null);
        Node<String> fourth = new Node<String>("dd", null);
        Node<String> fifth = new Node<String>("ee", null);
        Node<String> six = new Node<String>("ff", null);
        Node<String> seven = new Node<String>("gg", null);

        //完成结点之间的指向
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = seven;
        //产生环
        seven.next = third;
        //查找环的入口结点
        Node<String> entrance = getEntrance(first);
        System.out.println("first链表中环的入口结点元素为：" + entrance.item);
    }

    /**
     * @param first 链表首结点
     * @return 环的入口结点
     */
    public static Node getEntrance(Node<String> first) {
        Node<String> fast = first;
        Node<String> slow = first;
        Node<String> temp = null;

        // 思路1:通过快慢指针判断该链表是否有环[有环时声明新指针指向链表首结点继续遍历]
        // 思路2:当慢指针与临时指针指向同一结点时,该结点为环的入口
        while (fast != null && fast.next != null) {
            //1.通过快慢指针判断该链表是否有环[有环时声明新指针指向链表首结点继续遍历]
            fast = fast.next.next;
            slow = slow.next;
            if (fast.equals(slow)) {
                temp = first;
                continue;
            }
            //2.新指针开始遍历
            if (temp != null) {
                temp = temp.next;
                //3.通过新指针和慢指针找到环入口[当新指针和慢指针指向同一结点,该结点为环入口]
                if (temp.equals(slow)) {
                    break;
                }
            }
        }
        return temp;
    }
}
