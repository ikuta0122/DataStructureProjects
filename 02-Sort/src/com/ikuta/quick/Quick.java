package com.ikuta.quick;

public class Quick {
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
        int low = 0;
        int high = arr.length - 1;
        sort(arr, low, high);
    }

    //对数组arr中从low到high的元素进行排序
    private static void sort(Comparable[] arr, int low, int high) {
        //0.安全性检验
        if (high <= low) {
            return;
        }
        //1.对数组arr中从low到high的元素进行分组
        int partition = partition(arr, low, high);
        //2.1左子组有序
        sort(arr, low, partition - 1);
        //2.2右子组有序
        sort(arr, partition + 1, high);
    }

    //对数组arr中的子组[low,mid]和子组[mid+1,high]进行合并
    private static int partition(Comparable[] arr, int low, int high) {
        //1.确定分界值
        Comparable key = arr[low];
        //2.定义两个指针:左指针指向待切分数组的[最小索引处]和[最大索引处的下一个位置]
        int left = low;
        int right = high + 1;
        //3.切分数组
        while (true) {
            //3.1右指针right从尾部向头部搜索比分界值小的元素,搜索到即停止,并记录指针的位置
            while (less(key, arr[--right])) {
                if (right == low) {
                    break;
                }
            }
            //3.2左指针left从头部向尾部搜索比分界值大的元素,搜索到即停止,并记录指针的位置
            while (less(arr[++left], key)) {
                if (left == high) {
                    break;
                }
            }
            //3.3判断left是否大于等于right
            //返回true表示当前数组已经扫描完毕,结束循环
            //返回false表示当前数组尚未扫描完毕,需要交换元素然后继续扫描
            if (left >= right) {
                break;
            } else {
                exchange(arr, left, right);
            }
        }
        //3.4确定分界值位置
        exchange(arr, low, right);
        //3.5返回分界值位置
        return right;
    }
}
