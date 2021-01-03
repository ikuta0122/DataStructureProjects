package com.ikuta.priorityqueue;

public class TestMaxPriorityQueue {
    public static void main(String[] args) {
        //创建最大优先队列对象
        MaxPriorityQueue<Integer> maxPriorityQueue = new MaxPriorityQueue<>(10);
        //准备数据
        maxPriorityQueue.insert(7);
        maxPriorityQueue.insert(6);
        maxPriorityQueue.insert(4);
        maxPriorityQueue.insert(3);
        maxPriorityQueue.insert(1);
        maxPriorityQueue.insert(2);
        maxPriorityQueue.insert(5);
        maxPriorityQueue.insert(7);
        //获取最大元素
        while (!maxPriorityQueue.isEmpty()) {
            Integer delResult = maxPriorityQueue.delMax();
            System.out.println("此时被删除的最大元素为 : " + delResult);
        }
    }
}
