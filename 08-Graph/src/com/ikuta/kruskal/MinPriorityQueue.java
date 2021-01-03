package com.ikuta.kruskal;

public class MinPriorityQueue<T extends Comparable<T>> {
    //存储堆中的元素
    private T[] items;
    //记录堆中元素的个数
    private int N;

    public MinPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    /**
     * 获取队列的元素个数
     *
     * @return 队列的元素个数
     */
    public int size() {
        return N;
    }

    /**
     * 判断队列是否为空
     *
     * @return 返回true表示该队列为空, 反之亦然
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 判断堆中两个元素的大小
     *
     * @param i 索引号
     * @param j 索引号
     * @return 返回true表示索引i处的元素小于索引j处的元素, 反之亦然
     */
    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    /**
     * 交换堆中两个元素的位置
     *
     * @param i 索引号
     * @param j 索引号
     */
    private void exchange(int i, int j) {
        T tmp;
        tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    /**
     * 通过上浮算法使索引k处的元素处于正确位置
     *
     * @param k 待调整元素的索引号
     */
    private void swim(int k) {
        while (k > 1) {
            //1.比较当前结点[k]与其父结点[k/2]的值
            if (less(k / 2, k)) {
                //1.1如果父结点的值小于当前结点的值,那么结束循环
                return;
            } else {
                //1.2如果父结点的值大于等于当前结点的值,那么两者交换位置
                exchange(k / 2, k);
            }
            //2.当元素上浮现象发生时,当前结点与其新父结点再次比较大小,直至k=1
            k = k / 2;
        }
    }

    /**
     * 通过下沉算法使索引k处的元素处于正确位置
     *
     * @param k 待调整元素的索引号
     */
    private void sink(int k) {
        while (2 * k <= N) {
            //1.获取当前结点的较小子结点
            int lesser;
            if (2 * k + 1 > N) {//如果当前结点没有右子结点,则较小子结点为 2 * k
                lesser = 2 * k;
            } else {//如果当前结点存在右子结点,则较小子结点需要通过比较获取
                lesser = less(2 * k, 2 * k + 1) ? (2 * k) : (2 * k + 1);
            }
            //2.比较当前结点[k]与其较小子结点[lesser]
            if (less(k, lesser)) {
                //2.2如果当前结点的值小于其较小子结点,那么结束循环
                break;
            } else {
                //2.1如果当前结点的值大于等于其较小子结点,那么交换当前结点与其较小子结点的位置
                exchange(k, lesser);
            }
            //3.当发生元素下沉现象时,变换位置后的当前结点与其新较大子结点再次比较大小,直至 2 * k > N
            k = lesser;
        }
    }

    /**
     * 往堆中插入一个元素
     *
     * @param t 待插入元素
     */
    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    /**
     * 删除堆中的最小元素
     *
     * @return 被删除的最小元素
     */
    //删除堆中最小的元素,并返回这个最小元素
    public T delMin() {
        T min = items[1];
        exchange(1, N);
        N--;
        sink(1);
        return min;
    }
}
