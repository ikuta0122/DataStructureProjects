package com.ikuta.AI.undirectedgraph;

public class TestBreadthFirstSearch {
    public static void main(String[] args) {
        //准备无向图对象
        AIGraph graph = new AIGraph(13);
        //准备数据
        graph.addEdge(0, 5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 6);
        graph.addEdge(5, 3);
        graph.addEdge(5, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
        graph.addEdge(7, 8);
        graph.addEdge(9, 11);
        graph.addEdge(9, 10);
        graph.addEdge(9, 12);
        graph.addEdge(11, 12);
        //准备深度优先搜索对象
        BreadthFirstSearch search = new BreadthFirstSearch(graph, 0);
        //测试与某个顶点相通的顶点数量
        int count = search.count();
        System.out.println("起点0的相通顶点的数量 : " + count);
        //测试某个顶点与起点是否相通
        boolean marked = search.marked(5);
        System.out.println("顶点0和顶点5是否相通 ：" + marked);
    }
}
