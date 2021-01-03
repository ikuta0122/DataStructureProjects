package com.ikuta.binarytree;

public class TestBinaryTree {
    public static void main(String[] args) {
        //创建二叉查找树对象
        BinaryTree<Integer, String> bt = new BinaryTree<>();
        //测试插入
        bt.put(1, "张三");
        bt.put(2, "李四");
        bt.put(3, "王五");
        System.out.println("测试插入操作后的元素个数 : " + bt.size());
        //测试获取
        String getResult = bt.get(2);
        System.out.println("测试获取操作的结果 : " + getResult);
        //测试删除
        bt.delete(2);
        System.out.println("测试删除操作后的元素个数 : " + bt.size());
    }
}
