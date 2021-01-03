package com.ikuta.heap;

public class HeapSort {
    /**
     * 判断堆中两个元素的大小
     *
     * @param heap 待比较元素所在的堆
     * @param i    索引号
     * @param j    索引号
     * @return 返回true表示堆heap中的索引i处的元素小于索引j处的元素, 反之亦然
     */
    private static boolean less(Comparable[] heap, int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    /**
     * 交换堆中两个元素的位置
     *
     * @param heap 待交换元素所在的堆
     * @param i    索引号
     * @param j    索引号
     */
    private static void exchange(Comparable[] heap, int i, int j) {
        Comparable tmp;
        tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    /**
     * 使用下沉算法,使堆heap中索引target处的元素处于正确位置
     *
     * @param heap   堆
     * @param target 目标索引
     * @param range  堆中元素个数
     */
    private static void sink(Comparable[] heap, int target, int range) {
        while (2 * target <= range) {
            //1.获取当前结点的较大子结点[greater]
            int greater;
            if (2 * target + 1 > range) {////如果当前结点没有右子结点,则较大子结点为 2 * k
                greater = 2 * target;
            } else {//如果当前结点存在右子结点,则较大子结点需要通过比较获取
                if (less(heap, 2 * target, 2 * target + 1)) {
                    greater = 2 * target + 1;
                } else {
                    greater = 2 * target;
                }
            }
            //2.比较当前结点[k]与其较大子结点[greater]
            if (less(heap, target, greater)) {
                //2.1交换当前结点与其较大子结点的位置
                exchange(heap, target, greater);
            } else {
                //2.2如果当前结点的值大于等于其较大子结点,那么结束循环
                break;
            }
            //3.当发生元素下沉现象时,变换位置后的当前结点与其新较大子结点再次比较大小,直至 2 * k > range
            target = greater;
        }
    }
    /**
     * 将数组转化为堆[有序的数组]
     *
     * @param source 原数组
     * @param heap   目标数组[堆]
     */
    private static void createHeap(Comparable[] source, Comparable[] heap) {
        //1.将原数组的索引0~length-1处元素拷贝到新数组的索引1-length处
        System.arraycopy(source, 0, heap, 1, source.length);
        //2.获取新数组索引length/2~1处的元素并进行下沉处理
        for (int i = (heap.length) / 2; i > 0; i--) {
            sink(heap, i, heap.length - 1);
        }
    }

    /**
     * 按照数据大小[从小到大]排序数组
     *
     * @param source 源数组
     */
    public static void sort(Comparable[] source) {
        //1.构建堆
        Comparable[] heap = new Comparable[source.length + 1];
        createHeap(source, heap);
        //2.定义变量[记录需要参与下沉的元素个数]
        int count = heap.length - 1;
        //3.排序堆[直至堆中元素个数为1]
        while (count != 1) {
            //3.1交换元素[最大元素和最后元素]
            exchange(heap, 1, count);
            //3.2最大元素经过交换后,已处于正确位置,无需参与堆的下沉调整
            count--;
            //3.3最后元素经过交换后,需要参与堆的下沉调整
            sink(heap, 1, count);
        }
        //4.将已排序数组heap的数据拷贝到源数组source中
        System.arraycopy(heap, 1, source, 0, source.length);
    }
}
