package com.ikuta.stack;

public class TestStack {
    public static void main(String[] args) {
        //创建栈对象
        Stack<String> stack = new Stack<>();
        //测试压栈
        stack.push("张三");
        stack.push("李四");
        stack.push("王五");
        System.out.println("测试压栈后的元素个数 : " + stack.size());
        //测试弹栈
        String popResult = stack.pop();
        System.out.println("测试弹栈的结果 : " + popResult);
        System.out.println("测试弹栈后的元素个数 : " + stack.size());
        //测试遍历栈
        for (String item : stack) {
            System.out.println(item);
        }
    }
}
