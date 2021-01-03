package com.ikuta.priorityqueue;

import java.util.NoSuchElementException;

public class IndexMinPriorityQueue<Key extends Comparable<? super Key>> {
    /**
     * 索引最小优先队列,保存对象在数组中的位置
     * 按索引值(即keys[i],i为索引)进行小堆排序
     */
    private int[] pq;
    /**
     * 队列最大元素数
     */
    private int maxSize;
    /**
     * 当前队列元素数量
     */
    private int currentSize;
    /**
     * pq的逆序,保存对象索引在pq中的位置
     */
    private int[] qp;
    /**
     * 具体元素,保存对象
     */
    private Key[] keys;

    public IndexMinPriorityQueue(int maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException("参数非法");
        }
        this.maxSize = maxSize;
        pq = new int[maxSize + 1];
        qp = new int[maxSize + 1];
        keys = (Key[]) new Comparable[maxSize + 1];
        currentSize = 0;
        //逆序数组qp的所有元素初始化为-1,表示没有索引关联的对象
        for (int i = 0; i < maxSize + 1; i++) {
            qp[i] = -1;
        }
    }

    /**
     * 检查索引是否越界
     *
     * @param index 索引号
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= maxSize) {
            throw new IndexOutOfBoundsException("参数越界");
        }
    }

    /**
     * 获取队列中指定索引所对应的元素
     *
     * @param i 索引号
     * @return 返回指定元素
     */
    public Key keyOf(int i) {
        checkIndex(i);
        if (!contains(i)) throw new NoSuchElementException("不存在该索引");
        return keys[i];
    }

    /**
     * 获取队列中最小元素的索引
     *
     * @return 最小元素的索引
     */
    public int minIndex() {
        if (isEmpty()) {
            throw new NoSuchElementException("队列为空");
        }
        return pq[1];
    }

    /**
     * 判断队列是否为空
     *
     * @return 返回true表示队列为空
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * 获取队列的元素个数
     *
     * @return 队列的元素个数
     */
    public int size() {
        return currentSize;
    }

    /**
     * 判断队列中是否存在指定索引所对应的元素
     *
     * @param index 指定元素的关联整数
     * @return 返回true表示存在, 反之亦然
     */
    public boolean contains(int index) {
        checkIndex(index);
        return qp[index] != -1;
    }

    /**
     * 判断队列中两个索引所对应值的大小
     *
     * @param i 索引号
     * @param j 索引号
     * @return 返回true表示队列中索引i处对应的值小于索引j处对应的值
     */
    private boolean less(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
    }

    /**
     * 交换优先队列中两处索引的值
     *
     * @param i 索引号
     * @param j 索引号
     */
    private void exchange(int i, int j) {
        //1.交换优先队列中两处索引的值
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
        //2.更新逆序数组qp
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    /**
     * 上浮操作
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
     * 下沉操作
     */
    private void sink(int k) {
        while (2 * k <= currentSize) {
            //1.获取当前结点的较小子结点
            int lesser;
            if (2 * k + 1 > currentSize) {//如果当前结点没有右子结点,则较小子结点为 2 * k
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
     * 往队列中插入一对值
     *
     * @param index 索引
     * @param key   索引关联的值
     */
    public void insert(int index, Key key) {
        checkIndex(index);
        if (contains(index)) {
            throw new IllegalArgumentException("索引" + index + "已存在");
        }
        //1.元素个数+1
        currentSize++;
        //2.插入对象
        qp[index] = currentSize;
        pq[currentSize] = index;
        keys[index] = key;
        //3.通过上浮完成对调整
        swim(currentSize);
    }

    /**
     * 删除队列中的最小键并返回其关联索引
     *
     * @return 被删除最小键的关联索引, 即pq[1]
     */
    public int delMin() {
        if (currentSize == 0) {
            return -1;
        }
        //1.获取队列中的最小元素的关联索引
        int minIndex = pq[1];
        //2.交换优先队列pq中的索引1处和最大索引处的元素
        exchange(1, currentSize);
        //3.元素个数减1
        currentSize--;
        //4.通过下沉算法完成堆排序
        sink(1);
        //5.删除最小键
        qp[minIndex] = -1;
        pq[currentSize + 1] = -1;//不是必须的
        keys[minIndex] = null;
        //6.返回最小键的关联索引
        return minIndex;
    }

    /**
     * 删除队列中的指定
     *
     * @param i 待删除元素的关联索引
     */
    public void delete(int i) {
        //0.安全性检验
        checkIndex(i);
        if (!contains(i)) {
            throw new IllegalArgumentException("索引不存在");
        }
        //1.获取指定元素的关联索引
        int index = qp[i];
        //2.交换pq中索引k处的值和最大索引处的值
        exchange(index, currentSize);
        //3.元素个数减1
        currentSize--;
        //4.堆排序
        swim(index);
        sink(index);
        //5.删除指定元素
        qp[i] = -1;
        pq[currentSize + 1] = -1;//不是必须的
        keys[index] = null;
    }

    /**
     * 修改队列中指定元素的key值
     */
    public void changeKey(int i, Key key) {
        checkIndex(i);
        if (!contains(i)) throw new NoSuchElementException("不存在该索引");
        //1.修改元素
        keys[i] = key;
        //2.堆排序
        swim(qp[i]);
        sink(qp[i]);
    }
}
