package com.ikuta.AI.undirectedgraph;

public class TestAIGraph {
    public static void main(String[] args) {
        //创建无向图对象
        AIGraph graph = new AIGraph(12);
        graph.addEdge(1, 5);
        graph.addEdge(1, 7);
        graph.addEdge(1, 9);
        graph.addEdge(1, 11);
        graph.addEdge(1, 10);
        //测试获取
        Queue<Integer> nodes = graph.adj(1);
        System.out.print("当前结点为1,其相接结点有 : ");
        for (Integer node : nodes) {
            System.out.print(node + " ");
        }
    }
}
