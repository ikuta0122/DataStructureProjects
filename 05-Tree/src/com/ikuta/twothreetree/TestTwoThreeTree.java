package com.ikuta.twothreetree;

public class TestTwoThreeTree {
    public static void main(String[] args) {
        //创建2-3查找树对象
        TwoThreeTree<Integer,String> tree = new TwoThreeTree<>();
        //测试插入
        tree.insert(1,"A");
        tree.insert(2,"Z");
        tree.insert(3,"H");
        tree.insert(4,"M");
        //测试查找
        String findResult = tree.find(3);
        System.out.println("查找结果 : " + findResult);
    }
}
