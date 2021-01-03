package com.ikuta.AI.undirectedgraph;

public class TestTrafficProject {
    public static void main(String[] args) {
        //1.创建一个图Graph对象，表示城市
        AIGraph graph = new AIGraph(20);
        //2.调用addEdge()方法将已经修建好的道路所对应的城市连接起来
        graph.addEdge(0, 1);
        graph.addEdge(6, 9);
        graph.addEdge(3, 8);
        graph.addEdge(5, 11);
        graph.addEdge(2, 12);
        graph.addEdge(6, 10);
        graph.addEdge(4, 8);
        //3.通过Graph对象和顶点9，构建DepthFirstSearch对象或BreadthFirstSearch对象
        DepthFirstSearch search = new DepthFirstSearch(graph, 9);
        //4.调用marked()方法实现问题需求
        boolean result1 = search.marked(10);
        System.out.println("顶点9是否和顶点10相通? " + result1);
        boolean result2 = search.marked(8);
        System.out.println("顶点9是否和顶点8相通? " + result2);
    }
}
