package com.ikuta.linklist.twowaylinklist;


public class TestTwoWayLinkList {
    public static void main(String[] args) {
        //创建双向链表对象
        TwoWayLinkList<String> t1 = new TwoWayLinkList<>();
        //测试插入
        t1.insert("张三");
        t1.insert("李四");
        t1.insert(1, "王五");
        //测试遍历
        for (String str : t1) {
            System.out.println(str);
        }
        //测试获取
        String getResult = t1.get(2);
        System.out.println("获取索引2处的结果 : " + getResult);
        String getFirst = t1.getFirst();
        System.out.println("获取第一个元素 : " + getFirst);
        String getLast = t1.getLast();
        System.out.println("获取最后一个元素 : " + getLast);
        //测试删除
        String removeResult = t1.remove(1);
        System.out.println("删除索引1处的结果 : " + removeResult);
        //测试清空
        t1.clear();
        System.out.println("删除顺序表后的元素个数 : " + t1.length());

    }
}
