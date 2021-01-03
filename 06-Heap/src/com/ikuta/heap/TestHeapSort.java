package com.ikuta.heap;

public class TestHeapSort {
    public static void main(String[] args) {
        //准备数组
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        //排序数组
        HeapSort.sort(arr);
        //打印结果[A E E L M O P R S T X ]
        for (String item : arr) {
            System.out.print(item + " ");
        }
    }
}
