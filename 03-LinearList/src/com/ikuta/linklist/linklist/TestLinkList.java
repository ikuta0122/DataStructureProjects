package com.ikuta.linklist.linklist;

public class TestLinkList {
    public static void main(String[] args) {
        //创建单向链表对象
        LinkList<String> linklist = new LinkList<>();
        //测试添加
        linklist.insert("张三");
        linklist.insert("李四");
        linklist.insert("王五");
        //测试链表反转
        linklist.reverse();
        //测试遍历
        for (String str : linklist) {
            System.out.println(str);
        }
        //测试获取
        String getResult = linklist.get(1);
        System.out.println("测试获取索引1处的结果 : " + getResult);
        //测试删除
        String removeResult = linklist.remove(1);
        System.out.println("测试删除索引1处的结果 : " + removeResult);
        //测试清空
        linklist.clear();
        System.out.println("测试清空后的链表元素个数 : " + linklist.length());
    }
}
