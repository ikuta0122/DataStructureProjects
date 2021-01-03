package com.ikuta.AI.undirectedgraph;

import java.util.Stack;

public class TestDepthFirstPaths {
    public static void main(String[] args) {
        //创建图对象
        AIGraph graph = new AIGraph(6);
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(3, 4);
        graph.addEdge(0, 5);
        //创建深度优先搜索路径对象
        DepthFirstPaths paths = new DepthFirstPaths(graph, 0);
        //测试获取路径方法
        Stack<Integer> path = paths.pathTo(4);
        for (Integer v : path) {
            System.out.print(v + " ");
        }
    }
}
