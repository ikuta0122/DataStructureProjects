package com.ikuta.AI.undirectedgraph;

public class TestDepthFirstSearch {
    public static void main(String[] args) {
        //准备图对象
        AIGraph G = new AIGraph(13);
        G.addEdge(0, 5);
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(0, 6);
        G.addEdge(5, 3);
        G.addEdge(5, 4);
        G.addEdge(3, 4);
        G.addEdge(4, 6);
        G.addEdge(7, 8);
        G.addEdge(9, 11);
        G.addEdge(9, 10);
        G.addEdge(9, 12);
        G.addEdge(11, 12);
        //准备深度优先搜索对象
        DepthFirstSearch search = new DepthFirstSearch(G, 0);
        System.out.println();
        //测试与某个顶点相通的顶点数量
        int count = search.count();
        System.out.println("起点0的相通顶点的数量 : " + count);
        //测试某个顶点与起点是否相通
        boolean marked = search.marked(5);
        System.out.println("顶点0和顶点5是否相通 ：" + marked);
    }
}