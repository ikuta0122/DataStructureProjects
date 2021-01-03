package com.ikuta.binarytree;

public class BinaryTree<Key extends Comparable<Key>, Value> {
    //记录根结点
    private Node root;
    //记录树中元素的个数
    private int N;

    private class Node {
        //存储键
        public Key key;
        //存储值
        private Value value;
        //记录左子结点
        public Node left;
        //记录右子结点
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 获取树中元素的个数
     */
    public int size() {
        return N;
    }

    /**
     * 向树中添加元素key-value
     */
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    /**
     * 向指定的树x中添加key-value,并返回添加元素后新的树
     */
    private Node put(Node x, Key key, Value value) {
        //1.如果x子树为空
        if (x == null) {
            N++;
            return new Node(key, value, null, null);
        }
        //2.如果x子树不为空[比较x结点的键和key的大小]
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            //2.1如果key大于x结点的键，则继续找x结点的右子树
            x.right = put(x.right, key, value);
        } else if (cmp < 0) {
            //2.2如果key小于x结点的键，则继续找x结点的左子树
            x.left = put(x.left, key, value);
        } else {
            //2.3如果key等于x结点的键，则替换x结点的值为value即可
            x.value = value;
        }
        //3.返回添加元素后新的树
        return x;
    }

    /**
     * 查询树中指定key对应的value
     */
    public Value get(Key key) {
        return get(root, key);
    }

    /**
     * 从指定的树x中查找key对应的值
     */
    public Value get(Node x, Key key) {
        //1.如果x树为null
        if (x == null) {
            return null;
        }
        //2.如果x树不为null[比较key和x结点的键的大小]
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            //2.1如果key大于x结点的键，则继续找x结点的右子树
            return get(x.right, key);
        } else if (cmp < 0) {
            //2.2如果key小于x结点的键，则继续找x结点的左子树
            return get(x.left, key);
        } else {
            //2.3如果key等于x结点的键，就找到了键为key的结点，只需要返回x结点的值即可
            return x.value;
        }
    }


    /**
     * 删除树中key对应的value
     */
    public void delete(Key key) {
        root = delete(root, key);
    }

    /**
     * 删除指定树x中的key对应的value，并返回删除后的新树
     */
    public Node delete(Node x, Key key) {
        //第一步:如果待删除结点对应的树不存在，则直接返回null
        if (x == null) {
            return null;
        }

        //第二步:如果待删除结点对应的树存在，则从树中寻找key对应的待删除结点：
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            //1.如果待删除结点的key小于当前结点的key，则继续找当前结点的左子结点
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            //2.如果待删除结点的key大于当前结点的key，则继续找当前结点的右子结点
            x.right = delete(x.right, key);
        } else if (cmp == 0) {
            //3.如果待删除结点的key等于当前结点的key，则进行删除待删除结点操作

            //第三步:删除待删除结点操作
            //1.如果待删除结点的度为0,则直接删除结点
            if (x.left == null && x.right == null) {
                x = null;
            }
            //2.如果待删除结点的度为1,则直接返回待删除结点的左子树/右子树
            if (x.left == null) {
                N--;
                return x.right;
            }
            if (x.right == null) {
                N--;
                return x.left;
            }
            //3.如果待删除结点的度为2,则需要使用待删除结点的右子树中的最小结点minNode代替待删除结点

            //第四步:使用待删除结点的右子树中的最小结点minNode代替待删除结点
            //1.获取待删除结点的右子树中的最小结点minNode
            Node minNode = x;//x表示待删除结点
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            //2.删除待删除结点的右子树中的最小结点
            Node n = x.right;
            while (n.left != null) {
                if (n.left.left == null) {
                    n.left = null;
                    break;
                }
                n = n.left;
            }
            //3.让待删除结点的父结点成为最小结点minNode的父结点
            x = minNode;
            //4.让待删除结点的左子树成为最小结点minNode的左子树
            minNode.left = x.left;
            //5.让待删除结点的右子树成为最小结点minNode的右子树
            minNode.right = x.right;

            //第五步:元素个数减少1
            N--;
        }
        //第六步:返回删除后的新树
        return x;
    }

    /**
     * 获取整个树中的最小键
     */
    public Key min() {
        return min(root).key;
    }

    /**
     * 获取指定树X中的最小键所在结点
     * 根据二叉树的特征[左小右大]去寻找指定树X中的最小键所在结点
     * 如果当前结点存在左子树,则继续向下寻找[递归调用]
     * 如果当前结点不存在左子树,则该结点为最小键所在结点
     */
    private Node min(Node x) {
        if (x.left != null) {
            return min(x.left);
        } else {
            return x;
        }
    }

    /**
     * 获取整个树中的最大键
     */
    public Key max() {
        return max(root).key;
    }

    /**
     * 获取指定树X中的最大键所在结点
     * 根据二叉树的特征[左小右大]去寻找指定树X中的最大键所在结点
     * 如果当前结点存在右子树,则继续向下寻找[递归调用]
     * 如果当前结点不存在右子树,则该结点为最大键所在结点
     */
    public Node max(Node x) {
        if (x.right != null) {
            return max(x.right);
        } else {
            return x;
        }
    }

    /**
     * 通过前序遍历获取树的所有键,并返回队列
     */
    public Queue<Key> preErgodic() {
        Queue<Key> keys = new Queue<>();
        preErgodic(root, keys);
        return keys;
    }

    /**
     * 通过前序遍历获取指定树x的所有键并放入队列中
     */
    private void preErgodic(Node x, Queue<Key> keys) {
        //0.安全性检验
        if (x == null) {
            return;
        }
        //1.把当前结点的key放入到队列中
        keys.enqueue(x.key);
        //2.如果当前结点的左子树不为空,则递归遍历左子树
        if (x.left != null) {
            preErgodic(x.left, keys);
        }
        //3.如果当前结点的右子树不为空,则递归遍历右子树
        if (x.right != null) {
            preErgodic(x.right, keys);
        }
    }

    /**
     * 通过中序遍历获取树的所有键,并返回队列
     */
    public Queue<Key> midErgodic() {
        Queue<Key> keys = new Queue<>();
        midErgodic(root, keys);
        return keys;
    }

    /**
     * 通过中序遍历获取指定树x的所有键并放入队列中
     */
    private void midErgodic(Node x, Queue<Key> keys) {
        //0.安全性检验[指定树x是否为空]
        if (x == null) {
            return;
        }
        //1.如果当前结点的左子树不为空,则递归遍历左子树
        if (x.left != null) {
            midErgodic(x.left, keys);
        }
        //2.把当前结点的key放入到队列中
        keys.enqueue(x.key);
        //3.如果当前结点的右子树不为空,则递归遍历右子树
        if (x.right != null) {
            midErgodic(x.right, keys);
        }

    }

    /**
     * 通过后序遍历获取树的所有键,并返回队列
     */
    public Queue<Key> afterErgodic() {
        Queue<Key> keys = new Queue<>();
        afterErgodic(root, keys);
        return keys;
    }

    /**
     * 通过后序遍历获取指定树x的所有键并放入队列中
     */
    private void afterErgodic(Node x, Queue<Key> keys) {
        //0.安全性检验[执行树x是否为空]
        if (x == null) {
            return;
        }
        //1.如果当前结点的左子树不为空,则递归遍历左子树
        if (x.left != null) {
            afterErgodic(x.left, keys);
        }
        //2.如果当前结点的右子树不为空,则递归遍历右子树
        if (x.right != null) {
            afterErgodic(x.right, keys);
        }
        //3.把当前结点的key放入到队列中
        keys.enqueue(x.key);
    }

    /**
     * 用过层序遍历获取树的所有键,并返回队列
     */
    public Queue<Key> layerErgodic() {
        //第一步:层序遍历的准备
        //1.定义队列keys用于存储树的所有键
        Queue<Key> keys = new Queue<>();
        //2.定义队列nodes用于存储树的所有结点
        Queue<Node> nodes = new Queue<>();
        //3.队列nodes默认存储根结点
        nodes.enqueue(root);

        //第二步:队列nodes中弹出当前结点,将当前结点的key放入到队列keys中
        //第三步:判断当前结点是否存在左右子节点,如果存在则将其放入到队列nodes中作为下一个弹出结点
        //第四步:重复第二步和第三步操作,直至队列nodes中的元素个数为0
        while (!nodes.isEmpty()) {
            Node n = nodes.dequeue();
            keys.enqueue(n.key);
            if (n.left != null) {
                nodes.enqueue(n.left);
            }
            if (n.right != null) {
                nodes.enqueue(n.right);
            }
        }
        //第五步:返回队列keys
        return keys;
    }

    /**
     * 获取整个树的最大深度
     */
    public int maxDepth() {
        return maxDepth(root);
    }

    /**
     * 获取指定树x的最大深度
     */
    private int maxDepth(Node x) {
        //1.安全性检验[指定树是否为空]
        if (x == null) {
            return 0;
        }
        //2.声明变量用于存储指定树、左子树和右子树的最大深度
        int max;
        int maxL = 0;
        int maxR = 0;
        //3.计算指定树的左右子树的最大深度[递归调用]
        if (x.left != null) {
            maxL = maxDepth(x.left);
        }
        if (x.right != null) {
            maxR = maxDepth(x.right);
        }
        //4.获取指定树的最大深度
        max = (maxL > maxR ? maxL : maxR) + 1;
        //5.返回指定树的最大深度
        return max;
    }
}