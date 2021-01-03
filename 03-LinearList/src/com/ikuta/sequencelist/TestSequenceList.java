package com.ikuta.sequencelist;

public class TestSequenceList {
    public static void main(String[] args) {
        //创建顺序表对象
        SequenceList<String> s1 = new SequenceList<>(2);
        //测试插入
        s1.insert("张三");
        s1.insert("李四");
        s1.insert(1, "王五");
        //测试遍历
        for (String s: s1) {
            System.out.println(s);
        }
        //测试获取
        String getResult = s1.get(2);
        System.out.println("获取索引2处的结果 : " + getResult);
        //测试删除
        String removeResult = s1.remove(1);
        System.out.println("删除索引1处的结果 : " + removeResult);
        //测试清空
        s1.clear();
        System.out.println("删除顺序表后的元素个数 : " + s1.length());

    }
}
