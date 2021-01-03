package com.ikuta.AI.undirectedgraph;

public class AIGraph {
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

    public AIGraph(int v) {
        //1.初始化顶点数量
        this.V = v;
        //2.初始化边的数量
        this.E = 0;
        //3.初始化邻接表
        this.adj = new Queue[v];
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
     * 获取边数目
     *
     * @return 边数目
     */
    public int E() {
        return E;
    }

    /**
     * 在无向图中添加边
     *
     * @param v 待连接顶点
     * @param w 待连接顶点
     */
    public void addEdge(int v, int w) {
        adj[v].enqueue(w);//v的邻接表中添加w
        adj[w].enqueue(v);//w的邻接表中添加v
        E++;//边的数目+1
    }

    /**
     * 获取目标顶点的所有相邻顶点的队列
     *
     * @param v 目标顶点
     * @return 目标顶点的所有相邻顶点的队列
     */
    public Queue<Integer> adj(int v) {
        return adj[v];
    }
}
