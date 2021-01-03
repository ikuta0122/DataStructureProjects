package com.ikuta.weighted.directedgraph;

import com.ikuta.AI.undirectedgraph.Queue;

public class WeightedDirectedGraph {
    /**
     * 图的顶点数
     */
    private final int V;
    /**
     * 图的边数
     */
    private int E;
    /**
     * 辅助队列数组[用于存储顶点的邻接表]
     * 索引号表示顶点
     * 索引值表示当前顶点指出的所有边
     */
    private Queue<DirectedEdge>[] adj;

    /**
     * 带参构造器
     *
     * @param V 图的顶点数
     */
    public WeightedDirectedGraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<DirectedEdge>();
        }
    }

    /**
     * 获取图的顶点数
     *
     * @return 图的顶点数
     */
    public int V() {
        return V;
    }

    /**
     * 获取图的边数
     *
     * @return 图的边数
     */
    public int E() {
        return E;
    }


    /**
     * 往加权有向图中添加一条边
     *
     * @param e 待加入边
     */
    public void addEdge(DirectedEdge e) {
        int v = e.from();//获取边的起点顶点
        adj[v].enqueue(e);//辅助队列数组存储由当前顶点指出的所有边
        E++;//边的数量+1
    }

    /**
     * 获取当前顶点指出的所有边
     *
     * @param v 顶点
     * @return 存储当前顶点指出的所有边的队列
     */
    public Queue<DirectedEdge> adj(int v) {
        return adj[v];
    }

    /**
     * 获取加权有向图的所有边
     *
     * @return 存储加权有向图的所有边的队列
     */
    public Queue<DirectedEdge> edges() {
        Queue<DirectedEdge> allEdges = new Queue<>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge edge : adj[v]) {
                allEdges.enqueue(edge);
            }
        }
        return allEdges;
    }
}
