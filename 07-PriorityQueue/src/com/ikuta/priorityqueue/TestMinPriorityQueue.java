package com.ikuta.priorityqueue;

public class TestMinPriorityQueue {
    public static void main(String[] args) {
        //创建最小优先队列对象
        MinPriorityQueue<Integer> minPriorityQueue = new MinPriorityQueue<>(10);
        //准备数据
        minPriorityQueue.insert(7);
        minPriorityQueue.insert(6);
        minPriorityQueue.insert(4);
        minPriorityQueue.insert(3);
        minPriorityQueue.insert(1);
        minPriorityQueue.insert(2);
        minPriorityQueue.insert(5);
        minPriorityQueue.insert(7);
        //获取最小元素
        while (!minPriorityQueue.isEmpty()) {
            Integer delResult = minPriorityQueue.delMin();
            System.out.println("此时被删除的最小元素为 : " + delResult);
        }
    }
}
