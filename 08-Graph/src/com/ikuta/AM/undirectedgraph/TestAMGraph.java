package com.ikuta.AM.undirectedgraph;

public class TestAMGraph {
    public static void main(String[] args) {
        //创建图
        AMGraph graph = new AMGraph(8, 9);
        //深度优先遍历[1 2 4 3 5 6 7 8]
        graph.dFSTraverse();
        System.out.println();
        //广度优先遍历[1 2 3 5 4 6 7 8 ]
        graph.bFSTraverse();
    }
}