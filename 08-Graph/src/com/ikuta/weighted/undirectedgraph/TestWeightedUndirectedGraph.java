package com.ikuta.weighted.undirectedgraph;

import com.ikuta.prim.Edge;
import com.ikuta.AI.undirectedgraph.Queue;

public class TestWeightedUndirectedGraph {
    public static void main(String[] args) {
        //创建加权无向图对象
        WeightedUndirectedGraph graph = new WeightedUndirectedGraph(6);
        graph.addEdge(new Edge(0, 1, 1));
        graph.addEdge(new Edge(0, 2, 1));
        graph.addEdge(new Edge(0, 5, 1));
        graph.addEdge(new Edge(1, 2, 2));
        graph.addEdge(new Edge(2, 3, 3));
        graph.addEdge(new Edge(2, 4, 3));
        graph.addEdge(new Edge(3, 4, 4));
        graph.addEdge(new Edge(3, 5, 4));

        //测试方法
        int vNumbers = graph.V();
        System.out.println("加权无向图的顶点数 : " + vNumbers);
        //加权无向图的顶点数 : 6
        int eNumbers = graph.E();
        System.out.println("加权无向图的边数 : " + eNumbers);
        //加权无向图的边数 : 8
        Queue<Edge> edgeQueueOf0 = graph.adj(0);
        for (Edge e : edgeQueueOf0) {
            System.out.print(e.other(0) + " ");
        }
        //1 2 5
        System.out.println();
        Queue<Edge> edgeQueueOfAll = graph.edges();
        for (Edge e : edgeQueueOfAll) {
            System.out.print(e.weight() + " ");
        }
        //1.0 1.0 1.0 2.0 3.0 3.0 4.0 4.0
    }
}
