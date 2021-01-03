package com.ikuta.prim;

import com.ikuta.AI.undirectedgraph.Queue;
import com.ikuta.weighted.undirectedgraph.WeightedUndirectedGraph;

public class TestPrimMST {
    public static void main(String[] args) throws Exception {
        //创建加权无向图对象
        WeightedUndirectedGraph graph = new WeightedUndirectedGraph(8);
        graph.addEdge(new Edge(4, 5, 0.35));
        graph.addEdge(new Edge(4, 7, 0.37));
        graph.addEdge(new Edge(5, 7, 0.28));
        graph.addEdge(new Edge(0, 7, 0.16));
        graph.addEdge(new Edge(1, 5, 0.32));
        graph.addEdge(new Edge(0, 4, 0.38));
        graph.addEdge(new Edge(2, 3, 0.17));
        graph.addEdge(new Edge(1, 7, 0.19));
        graph.addEdge(new Edge(0, 2, 0.26));
        graph.addEdge(new Edge(1, 2, 0.36));
        graph.addEdge(new Edge(1, 3, 0.29));
        graph.addEdge(new Edge(2, 7, 0.34));
        graph.addEdge(new Edge(6, 2, 0.40));
        graph.addEdge(new Edge(3, 6, 0.52));
        graph.addEdge(new Edge(6, 0, 0.58));
        graph.addEdge(new Edge(6, 4, 0.93));
        //创建Prim算法对象
        PrimMST mst = new PrimMST(graph);
        Queue<Edge> edges = mst.edges();
        for (Edge edge : edges) {
            int v = edge.either();
            int w = edge.other(v);
            System.out.println(v + "---->" + w + " : " + edge.weight());
        }
    }
}
