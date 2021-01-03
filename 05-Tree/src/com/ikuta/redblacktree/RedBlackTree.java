package com.ikuta.redblacktree;

public class RedBlackTree<Key extends Comparable<Key>, Value> {
    /**
     * 根节点
     */
    private Node root;
    /**
     * 树的元素个数
     */
    private int N;
    /**
     * 红链接
     */
    private static final boolean RED = true;
    /**
     * 黑链接
     */
    private static final boolean BLACK = false;

    /**
     * 内部结点类
     * key存储键
     * value存储值
     * left记录左子结点
     * right记录右子结点
     * color记录其父结点指向它的链接颜色
     */
    private class Node {
        public Key key;
        private Value value;
        public Node left;
        public Node right;
        public boolean color;

        public Node(Key key, Value value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }

    /**
     * 获取树的元素个数
     *
     * @return 树的元素个数
     */
    public int size() {
        return N;
    }

    /**
     * 判断当前结点的链接颜色[空链接默认为黑色]
     *
     * @param x 待判断连接颜色的结点
     * @return 返回true表示当前结点的连接颜色为红色, 返回false表示当前结点的链接颜色为黑色
     */
    private boolean isRed(Node x) {
        //空链接默认为黑色
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    /**
     * 左旋调整
     *
     * @param h 待左旋调整的结点
     * @return 左旋调整后的结点
     */
    private Node rotateLeft(Node h) {
        //0.获取当前结点h的右子结点x
        Node x = h.right;
        //1.让x的左子结点变为h的右子结点
        h.right = x.left;
        //2.让h成为x的左子结点
        x.left = h;
        //3.让x的color属性变为h的color属性值
        x.color = h.color;
        //4.让h的color属性变为RED
        h.color = RED;
        //5.返回左旋调整后的结点
        return x;
    }

    /**
     * 右旋调整
     *
     * @param h 待右旋调整的结点
     * @return 右旋调整后的结点
     */
    private Node rotateRight(Node h) {
        //0.获取当前结点h的左子结点 x
        Node x = h.left;
        //1.让x的右子结点成为h的左子结点
        h.left = x.right;
        //2.让h成为x的右子结点
        x.right = h;
        //3.让x的color变为h的color属性值
        x.color = h.color;
        //4.让h的color属性变为RED[注意:通过颜色反转解决结点x的右链接颜色问题]
        h.color = RED;
        //5.返回右旋调整的结点
        return x;
    }

    /**
     * 颜色反转[拆分临时4-结点]
     *
     * @param h 待颜色反转的结点
     */
    private void flipColors(Node h) {
        //1.左子结点和右子结点的颜色转变为黑色
        h.left.color = BLACK;
        h.right.color = BLACK;
        //2.当前结点的颜色转变为红色
        h.color = RED;
    }

    /**
     * 往树中插入元素[键值对]
     *
     * @param key 待插入元素的键
     * @param val 待插入元素的值
     */
    public void put(Key key, Value val) {
        //1.调用重载方法实现插入
        root = put(root, key, val);
        //2.确保根结点的颜色总是黑色[非必须,不影响结果]
        root.color = BLACK;
    }

    /**
     * 往指定树中插入元素[键值对],并返回新生成的树
     *
     * @param h   指定树
     * @param key 待插入结点的键
     * @param val 待插入结点的值
     */
    private Node put(Node h, Key key, Value val) {
        //第一步:判断指定树是否为空
        //1.如果指定树为空,那么返回一个红色结点同时结束方法
        if (h == null) {
            N++;
            return new Node(key, val, null, null, RED);
        }
        //2.如果指定树非空,那么需要比较指定树h的key和待插入结点的key
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, val);
        } else if (cmp > 0) {
            h.right = put(h.right, key, val);
        } else if (cmp == 0) {
            h.value = val;
        }

        //第二步:在插入结点非空的基础上,判断当前结点是否符合红黑树的规范
        //1.左旋调整[当前结点的左子结点为黑色，右子结点为红色]
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        //2.右旋调整[当前结点的左子结点是红色，且左子结点的左子结点也是红色]
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        //3.颜色反转[当前结点的左子结点和右子结点都为红色]
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        //第三步:返回新生成的树
        return h;
    }

    /**
     * 在树中查找结点
     *
     * @param key 待查找结点的键
     * @return 待查找元素的值
     */
    public Value get(Key key) {
        return get(root, key);
    }

    /**
     * 在指定树中查找结点
     *
     * @param x   指定树
     * @param key 待查找结点的键
     * @return 待查找结点的值
     */
    private Value get(Node x, Key key) {
        //第一步:判断指定树是否为空
        //1.如果指定树为空,那么直接返回null同时结束方法
        if (x == null) {
            return null;
        }
        //2.如果指定树非空,那么需要比较指定树x的key和待查找结点的key
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.value;
        }
    }
}
