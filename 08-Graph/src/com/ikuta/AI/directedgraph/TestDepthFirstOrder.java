package com.ikuta.AI.directedgraph;

public class TestDepthFirstOrder {
    public static void main(String[] args) {
        //创建有向图对象
        AIDGraph graph = new AIDGraph(6);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        //测试顶点排序[1 0 3 2 4 5 ]
        DepthFirstOrder order = new DepthFirstOrder(graph);
        Stack<Integer> stack = order.reversePost();
        for (Integer v : stack) {
            System.out.print(v + " ");
        }
    }
}
