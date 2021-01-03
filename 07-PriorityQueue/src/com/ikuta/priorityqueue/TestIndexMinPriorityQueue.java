package com.ikuta.priorityqueue;

public class TestIndexMinPriorityQueue {
    public static void main(String[] args) {
        //创建索引最小优先队列对象
        IndexMinPriorityQueue<String> queue = new IndexMinPriorityQueue<>(10);
        //测试插入
        queue.insert(1, "A");
        queue.insert(7, "H");
        queue.insert(8, "I");
        //测试修改元素
        queue.changeKey(7, "Z");
        System.out.println("被修改元素的key值 : " + queue.keyOf(7));
        //测试删除指定键
        queue.delete(7);
        System.out.println("元素个数 : " + queue.size());
        //测试删除最小键
        while (!queue.isEmpty()){
            int delResult = queue.delMin();
            System.out.println("最小键的关联索引 : " + delResult);
        }
    }
}
