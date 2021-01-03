package com.ikuta.AI.directedgraph;

import com.ikuta.AI.undirectedgraph.Queue;

public class TestAIDGraph {
    public static void main(String[] args) {
        //创建有向图对象
        AIDGraph graph = new AIDGraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        //测试获取指定顶点指向的所有顶点[2 3 ]
        Queue<Integer> queue = graph.adj(1);
        for (Integer v : queue) {
            System.out.print(v + " ");
        }
        System.out.println();
        //测试获取指向指定顶点的所有顶点[0 ]
        AIDGraph revGraph = graph.reverse();
        Queue<Integer> revQueue = revGraph.adj(1);
        for (Integer v : revQueue) {
            System.out.print(v + " ");
        }
    }
}
