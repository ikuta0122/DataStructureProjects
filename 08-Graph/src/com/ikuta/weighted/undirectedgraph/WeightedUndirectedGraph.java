package com.ikuta.weighted.undirectedgraph;

import com.ikuta.prim.Edge;
import com.ikuta.AI.undirectedgraph.Queue;

public class WeightedUndirectedGraph {
    /**
     * 加权无向图的顶点数
     */
    private final int V;
    /**
     * 加权无向图的边数
     */
    private int E;
    /**
     * 顶点的邻接表
     */
    private Queue<Edge>[] adj;

    /**
     * 带参构造器
     *
     * @param V 顶点数
     */
    public WeightedUndirectedGraph(int V) {
        //1.初始化顶点数
        this.V = V;
        //2.初始化边数
        this.E = 0;
        //3.初始化每个顶点的邻接表
        this.adj = new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<Edge>();
        }
    }

    /**
     * 获取加权无向图的顶点数
     *
     * @return 顶点数
     */
    public int V() {
        return V;
    }

    /**
     * 获取加权无向图的边数
     *
     * @return 边数
     */
    public int E() {
        return E;
    }

    /**
     * 往加权无向图中添加一条边
     *
     * @param e 待插入边
     */
    public void addEdge(Edge e) {
        //1.指定边两个顶点的邻接表中添加指定边信息
        int v = e.either();
        int w = e.other(v);
        adj[v].enqueue(e);
        adj[w].enqueue(e);
        //2.边的数量+1
        E++;
    }

    /**
     * 获取指定顶点的所有边
     *
     * @param v 顶点
     * @return 顶点的所有边
     */
    public Queue<Edge> adj(int v) {
        return adj[v];
    }

    /**
     * 获取存储加权无向图所有边的队列
     *
     * @return 存储所有边的队列
     */
    public Queue<Edge> edges() {
        //1.声明队列allEdges用于存储加权无向图的所有边
        Queue<Edge> allEdges = new Queue<>();
        //2.遍历每个顶点的邻接表[将邻接表中的边放入队列allEdges中]
        //避免重复添加边的思想:顶点v的值 > 边e的另一个顶点w的值,表示边e已经在遍历顶点w时添加了
        for (int v = 0; v < V; v++) {
            for (Edge e : adj(v)) {
                if (v < e.other(v)) {
                    allEdges.enqueue(e);
                }
            }
        }
        return allEdges;
    }
}
