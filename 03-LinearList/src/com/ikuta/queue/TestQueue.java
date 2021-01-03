package com.ikuta.queue;

public class TestQueue {
    public static void main(String[] args) {
        //创建队列对象
        Queue<String> queue = new Queue<>();
        //测试入队
        queue.enqueue("张三");
        queue.enqueue("李四");
        queue.enqueue("王五");
        queue.enqueue("赵六");
        System.out.println("测试入队的元素个数 : " + queue.size());
        //测试出队
        String dequeueResult = queue.dequeue();
        System.out.println("测试出队的结果 : " + dequeueResult);
        System.out.println("测试出队的元素个数 : " + queue.size());
        //测试遍历
        for (String str : queue) {
            System.out.println(str);
        }
    }
}
