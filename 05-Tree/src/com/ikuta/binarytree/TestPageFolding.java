package com.ikuta.binarytree;

public class TestPageFolding {
    //内部结点类
    private static class Node<T> {
        public T item;//存储元素
        public Node left;
        public Node right;

        public Node(T item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        //获取二叉树对象的根结点
        Node<String> tree = createTree(3);
        //使用中序遍历模拟从上到下打印折痕的方向
        printTree(tree);
        //测试结果:down down up down down up up
    }

    /**
     * 模拟折纸过程创造二叉树对象
     *
     * @param N 折纸次数
     * @return 二叉树对象的根结点
     */
    public static Node<String> createTree(int N) {
        //0.定义根结点
        Node<String> root = null;
        for (int i = 1; i <= N; i++) {
            //情况一:此次对折为第一次对折
            if (i == 1) {
                root = new Node<>("down", null, null);
                continue;
            }
            //情况二:此次对折为第N[N > 1]此对折
            //1.定义辅助队列,通过层序遍历的思想寻找叶子结点[度为0]并为其添加子结点
            Queue<Node> nodes = new Queue<>();
            //2.将根结点放入到辅助队列中
            nodes.enqueue(root);
            //3.寻找当前树的叶子节点并为其添加左右子结点
            while (!nodes.isEmpty()) {
                Node<String> tmp = nodes.dequeue();
                if (tmp.left != null) {
                    nodes.enqueue(tmp.left);
                }
                if (tmp.right != null) {
                    nodes.enqueue(tmp.right);
                }
                if (tmp.left == null && tmp.right == null) {
                    tmp.left = new Node<String>("down", null, null);
                    tmp.right = new Node<String>("up", null, null);
                }
            }
        }
        return root;
    }


    /**
     * 使用中序遍历模拟从上到下打印每个折痕的方向
     *
     * @param root 待打印树的根结点
     */
    public static void printTree(Node<String> root) {
        //0.安全性检验
        if (root == null) {
            return;
        }
        //1.打印左子树的每个结点
        if (root.left != null) {
            printTree(root.left);
        }
        //2.打印当前结点
        System.out.print(root.item + " ");
        //3.打印右子树的每个结点
        if (root.right != null) {
            printTree(root.right);
        }
    }
}
