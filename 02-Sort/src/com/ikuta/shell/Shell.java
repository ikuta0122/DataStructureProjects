package com.ikuta.shell;

public class Shell {
    //对数组a中的元素进行排序
    public static void sort(Comparable[] a) {
        //第一步:确定增长量h
        int h = 1;
        while (h < a.length / 2) {
            h = 2 * h + 1;
        }

        while (h >= 1) {
            //第二步:找到待插入元素
            for (int i = h; i < a.length; i++) {
                //第三步:把待插入元素插入到已排序组中
                for (int j = i; j >= h; j -= h) {
                    if (greater(a[j - h], a[j])) {
                        exchange(a, j - h, j);
                    } else {
                        break;
                    }
                }
            }
            //第四步:减小增长量h
            h = h / 2;
        }
    }

    //比较v元素是否大于w元素
    private static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    //数组元素i和j交换位置
    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
