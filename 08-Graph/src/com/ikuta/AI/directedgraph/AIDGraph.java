package com.ikuta.AI.directedgraph;

import com.ikuta.AI.undirectedgraph.Queue;

public class AIDGraph {
    /**
     * 顶点数目
     */
    private final int V;
    /**
     * 边的数目
     */
    private int E;
    /**
     * 邻接表
     */
    private Queue<Integer>[] adj;

    public AIDGraph(int V) {
        //1.初始化顶点数量
        this.V = V;
        //2.初始化边的数量
        this.E = 0;
        //3.初始化邻接表
        this.adj = new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<Integer>();
        }
    }


    /**
     * 获取顶点数目
     *
     * @return 顶点数目
     */
    public int V() {
        return V;
    }

    /**
     * 获取边的数目
     *
     * @return 边的数目
     */
    public int E() {
        return E;
    }

    /**
     * 向有向图中添加一条由v指向w的边
     *
     * @param v 起点
     * @param w 终点
     */
    public void addEdge(int v, int w) {
        adj[v].enqueue(w);
        E++;
    }

    /**
     * 获取顶点v指向的所有顶点
     *
     * @param v 顶点
     * @return 顶点v指向的所有顶点
     */
    public Queue<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * 获取反向图
     *
     * @return 反向图
     */
    public AIDGraph reverse() {
        //1.创建有向图对象
        AIDGraph revGraph = new AIDGraph(V);
        //2.转换为反向图
        for (int v = 0; v < V; v++) {
            for (Integer w : adj[v]) {
                revGraph.addEdge(w, v);
            }
        }
        //3.返回反向图
        return revGraph;
    }
}
