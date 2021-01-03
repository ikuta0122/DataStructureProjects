package com.ikuta.heap;

public class Heap<T extends Comparable<T>> {
    //存储堆中的元素
    private T[] items;
    //记录堆中元素的个数
    private int N;

    public Heap(int capacity) {
        //堆中索引0处不存储元素
        this.items = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    /**
     * 判断堆中两个元素的大小
     *
     * @param i 索引号
     * @param j 索引号
     * @return 返回true表示索引i出的元素小于索引j处的元素, 反之亦然
     */
    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    /**
     * 交换堆中两个元素的位置
     *
     * @param i 索引号
     * @param j 苏哦引号
     */
    private void exchange(int i, int j) {
        T temp;
        temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    /**
     * 通过上浮算法使索引k处的元素处于正确位置
     *
     * @param k 索引号
     */
    private void swim(int k) {
        while (k > 1) {
            //1.比较当前结点[k]与其父结点[k/2]的值
            if (less(k / 2, k)) {
                //1.1如果父结点的值小于当前结点的值,那么两者交换位置
                exchange(k / 2, k);
            } else {
                //1.2如果父结点的值大于等于当前结点的值,那么结束循环
                return;
            }
            //2.当元素上浮现象发生时,当前结点与其新父结点再次比较大小,直至k=1
            k = k / 2;
        }
    }

    /**
     * 通过下沉算法使索引k处的元素处于正确位置
     *
     * @param k 索引号
     */
    private void sink(int k) {
        while (2 * k <= N) {
            //1.获取当前结点的较大子结点
            int greater;
            if (2 * k + 1 > N) {//如果当前结点没有右子结点,则较大子结点为 2 * k
                greater = 2 * k;
            } else {//如果当前结点存在右子结点,则较大子结点需要通过比较获取
                if (less(2 * k, 2 * k + 1)) {
                    greater = 2 * k + 1;
                } else {
                    greater = 2 * k;
                }
            }
            //2.比较当前结点[k]与其较大子结点[greater]
            if (less(k, greater)) {
                //2.1交换当前结点与其较大子结点的位置
                exchange(k, greater);
            } else {
                //2.2如果当前结点的值大于等于其较大子结点,那么结束循环
                break;
            }
            //3.当发生元素下沉现象时,变换位置后的当前结点与其新较大子结点再次比较大小,直至 2 * k > N
            k = greater;
        }
    }

    /**
     * 堆中插入元素
     *
     * @param t 待插入元素
     */
    public void insert(T t) {
        //1.往堆的最后面插入待插入元素t
        items[++N] = t;
        //2.使用上浮算法使索引N处的元素处于正确位置
        swim(N);
    }

    /**
     * 删除堆中的最大元素
     *
     * @return 被删除的最大元素
     */
    public T delMax() {
        //1.获取堆中的最大元素
        T max = items[1];
        //2.交换堆中最大元素和最小元素
        exchange(1, N);
        //3.删除堆中的最大元素
        items[N] = null;
        //4.元素个数减1
        N--;
        //5.通过下沉算法使索引1处的元素处于正确位置,让堆重新有序
        sink(1);
        //6.返回被删除的最大元素
        return max;
    }
}
