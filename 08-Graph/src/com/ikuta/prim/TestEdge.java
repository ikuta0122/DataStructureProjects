package com.ikuta.prim;

public class TestEdge {
    public static void main(String[] args) {
        //创建两个边对象
        Edge edge1 = new Edge(0, 1, 1);
        Edge edge2 = new Edge(0, 2, 2);
        //比较两个边的大小
        int result = edge1.compareTo(edge2);
        if (result == 0) {
            System.out.println("两条边的权重值相等");
        } else {
            System.out.println(result > 0 ? "edge1的权重值更大" : "edge2的权重值更大");
        }
    }
}
