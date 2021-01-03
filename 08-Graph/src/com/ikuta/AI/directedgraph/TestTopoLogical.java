package com.ikuta.AI.directedgraph;

public class TestTopoLogical {
    public static void main(String[] args) {
        //创建图对象
        AIDGraph graph = new AIDGraph(6);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        //测试拓扑排序[1 0 3 2 4 5 ]
        TopoLogical topo = new TopoLogical(graph);
        Stack<Integer> stack = topo.order();
        for (Integer v : stack) {
            System.out.print(v + " ");
        }
    }
}
