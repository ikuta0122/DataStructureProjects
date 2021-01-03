package com.ikuta.binarytree;

public class TestBinaryTreeErgodic {
    public static void main(String[] args) {
        //创建树对象
        BinaryTree<String, String> bt = new BinaryTree<>();
        //准备遍历数据
        bt.put("E", "5");
        bt.put("B", "2");
        bt.put("G", "7");
        bt.put("A", "1");
        bt.put("D", "4");
        bt.put("F", "6");
        bt.put("H", "8");
        bt.put("C", "3");

        //测试前序遍历[E B A D C G F H ]
        Queue<String> preKeys = bt.preErgodic();
        System.out.print("测试前序遍历:");
        for (String key : preKeys) {
            System.out.print(key + " ");
        }
        System.out.println();

        //测试中序遍历[A B C D E F G H ]
        Queue<String> midKeys = bt.midErgodic();
        System.out.print("测试中序遍历:");
        for (String key : midKeys) {
            System.out.print(key + " ");
        }
        System.out.println();

        //测试后序遍历[A C D B F H G E ]
        Queue<String> afterKeys = bt.afterErgodic();
        System.out.print("测试后续遍历:");
        for (String key : afterKeys) {
            System.out.print(key + " ");
        }
        System.out.println();

        //测试层序遍历[E B G A D F H C ]
        Queue<String> layerKeys = bt.layerErgodic();
        System.out.print("测试层序遍历:");
        for (String key : layerKeys) {
            System.out.print(key + " ");
        }
        System.out.println();

        //测试二叉树的最大深度问题[4]
        int maxDepth = bt.maxDepth();
        System.out.println("二叉树的最大深度 : " + maxDepth);
    }
}
