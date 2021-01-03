package com.ikuta.merge;

public class Merge {
    //归并所需要的辅助数组
    private static Comparable[] assist;

    //比较c1元素是否小于c2元素
    private static boolean less(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) < 0;
    }

    //数据元素i和元素j交换位置
    private static void exchange(Comparable[] arr, int i, int j) {
        Comparable temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //对数组arr中的元素进行排序
    public static void sort(Comparable[] arr) {
        //1.初始化辅助数组assist
        assist = new Comparable[arr.length];
        //2.声明变量low和变量high:用于记录数组中的最小索引和最大索引
        int low = 0;
        int high = arr.length - 1;
        //3.调用sort()方法完成数组arr中,从索引low到索引high的元素排序
        sort(arr, low, high);
    }

    //对数组arr中从low到high的元素进行排序
    private static void sort(Comparable[] arr, int low, int high) {
        //0.安全性检验[当子组元素只有1个时结束递归]
        if (high <= low) {
            return;
        }
        //1.对数组arr中从low到high之间的数据进行分组
        int mid = low + (high - low) / 2;
        //2.对每一个子组进行排序
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        //3.将排序后的子组归并
        merge(arr, low, mid, high);
    }

    //对数组arr中的子组[low,mid]和子组[mid+1,high]进行合并
    private static void merge(Comparable[] arr, int low, int mid, int high) {
        //1.定义三个指针
        int i = low;
        int p1 = low;
        int p2 = mid + 1;
        //2.1遍历:移动指针p1和指针p2,比较对应索引处的值,将两者中的较小值放到辅助数组的指针p3对应的索引处
        while (p1 <= mid && p2 <= high) {
            if (less(arr[p1], arr[p2])) {
                assist[i++] = arr[p1++];
            } else {
                assist[i++] = arr[p2++];
            }
        }
        //2.2遍历:如果p1的指针没有走完,则顺序移动p1指针将指针指向元素放到辅助数组的对应索引处
        while (p1 <= mid) {
            assist[i++] = arr[p1++];
        }
        //2.3遍历:如果p2的指针没有走完,则顺序移动p2指针将指针指向元素放到辅助数组的对应索引处
        while (p2 <= high) {
            assist[i++] = arr[p2++];
        }

        //3.将辅助数组中的元素拷贝到原数据组中
        for (int index = low; index <= high; index++) {
            arr[index] = assist[index];
        }
    }
}
