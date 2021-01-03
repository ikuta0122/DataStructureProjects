package com.ikuta.redblacktree;

public class TestRedBlackTree {
    public static void main(String[] args) {
        //创建红黑树
        RedBlackTree<Integer, String> tree = new RedBlackTree<>();
        //测试插入
        tree.put(1, "张三");
        tree.put(2, "李四");
        tree.put(3, "王五");
        //测试获取
        String getResult = tree.get(3);
        System.out.println("获取结果 : " + getResult);
    }
}
