package com.ikuta.shortestpath;

import com.ikuta.AI.undirectedgraph.Queue;
import com.ikuta.weighted.directedgraph.DirectedEdge;
import com.ikuta.weighted.directedgraph.WeightedDirectedGraph;

public class TestDijstraShortestPath {
    public static void main(String[] args) {
        //创建加权有向图对象
        WeightedDirectedGraph graph = new WeightedDirectedGraph(8);
        //添加边
        graph.addEdge(new DirectedEdge(4, 5, 0.35));
        graph.addEdge(new DirectedEdge(5, 4, 0.35));
        graph.addEdge(new DirectedEdge(4, 7, 0.37));
        graph.addEdge(new DirectedEdge(5, 7, 0.28));
        graph.addEdge(new DirectedEdge(7, 5, 0.28));
        graph.addEdge(new DirectedEdge(5, 1, 0.32));
        graph.addEdge(new DirectedEdge(0, 4, 0.38));
        graph.addEdge(new DirectedEdge(0, 2, 0.26));
        graph.addEdge(new DirectedEdge(7, 3, 0.39));
        graph.addEdge(new DirectedEdge(1, 3, 0.29));
        graph.addEdge(new DirectedEdge(2, 7, 0.34));
        graph.addEdge(new DirectedEdge(6, 2, 0.40));
        graph.addEdge(new DirectedEdge(3, 6, 0.52));
        graph.addEdge(new DirectedEdge(6, 0, 0.58));
        graph.addEdge(new DirectedEdge(6, 4, 0.93));
        //创建最短路径树对象
        DijstraShortestPath path = new DijstraShortestPath(graph, 0);
        Queue<DirectedEdge> shortestPath = path.pathTo(6);
        for (DirectedEdge edge : shortestPath) {
            System.out.println(edge.from() + "--->" + edge.to() + " : " + edge.weight());
        }
    }
}
