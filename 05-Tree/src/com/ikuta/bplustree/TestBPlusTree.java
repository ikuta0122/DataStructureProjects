package com.ikuta.bplustree;

public class TestBPlusTree {
    public static void main(String[] args) {
        //创建B+树对象
        BPlusTree<Integer, String> bPlusTree = new BPlusTree<>();
        //测试插入
        for (int i = 0; i < 10; i++) {
            bPlusTree.put(i, String.valueOf(i));
        }
        //测试查询
        System.out.println(bPlusTree.get(1));
    }
}
