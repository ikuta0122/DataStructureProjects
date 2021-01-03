package com.ikuta.AI.directedgraph;

public class TestDepthFirstCheck {
    public static void main(String[] args) {
        //创建有向图对象
        AIDGraph graph = new AIDGraph(5);
        graph.addEdge(3, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(1, 0);
        graph.addEdge(1, 4);
        //创建判断对象
        DepthFirstCheck check = new DepthFirstCheck(graph);
        boolean result = check.hasCycle();
        System.out.println("有向图是否存在环 : " + result);
    }
}
