package com.ikuta.heap;

public class TestHeap {
    public static void main(String[] args) {
        //创建堆对象
        Heap<String> heap = new Heap<String>(20);
        //准备数据
        heap.insert("B");
        heap.insert("F");
        heap.insert("A");
        heap.insert("E");
        heap.insert("G");
        heap.insert("C");
        heap.insert("D");
        String delResult;
        //通过循环从堆中删除数据[G F E D C B A ]
        while ((delResult = heap.delMax()) != null) {
            System.out.print(delResult + " ");
        }
    }
}
