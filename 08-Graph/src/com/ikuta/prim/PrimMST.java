package com.ikuta.prim;

import com.ikuta.AI.undirectedgraph.Queue;
import com.ikuta.weighted.undirectedgraph.WeightedUndirectedGraph;

public class PrimMST {
    /**
     * 辅助数组[用于存储当前顶点和最小生成树之间的最短边]
     * 索引号表示顶点
     * 索引值表示当前顶点和最小生成树之间的最短边
     */
    private Edge[] edgeTo;
    /**
     * 辅助数组[用于存储当前顶点和最小生成树之间的最短边的权重]
     * 索引号表示顶点
     * 索引值表示当前顶点和最小生成树之间的最短边的权重
     */
    private double[] distTo;
    /**
     * 辅助数组[用于存储当前顶点的状态]
     * 索引号表示顶点
     * 索引值表示当前顶点是否已经在最小生成树中
     */
    private boolean[] marked;
    /**
     * 最小索引优先队列[用于存储树中顶点和非树中顶点的有效横切边的权重]
     * 每次切分之后都会产生一系列新的有效横切边,通过最小索引优先队列获取最小的有效横切边
     * 索引号表示顶点
     * 索引值表示当前顶点和最小生成树的最小有效横切边的权重
     */
    private IndexMinPriorityQueue<Double> pq;

    /**
     * 带参构造器
     *
     * @param G 加权无向图
     */
    public PrimMST(WeightedUndirectedGraph G) {
        //1.初始化成员变量
        this.edgeTo = new Edge[G.V()];
        this.distTo = new double[G.V()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        this.marked = new boolean[G.V()];
        pq = new IndexMinPriorityQueue<Double>(G.V());

        //2.默认让顶点0进入到树中
        distTo[0] = 0.0;
        pq.insert(0, 0.0);

        //3.遍历最小索引优先队列,获取最小的有效横切边对应的顶点并将其加入到最小生成树中
        while (!pq.isEmpty()) {
            visit(G, pq.delMin());//最小索引优先队列弹出最短边的索引,加入到最小生成树中
        }
    }

    /**
     * 将顶点放入到最小生成树中,并更新数据
     *
     * @param G 加权无向图
     * @param v 顶点
     */
    private void visit(WeightedUndirectedGraph G, int v) {
        //第一步:顶点v放入到最小生成树中[顶点的状态标记设置为true]
        marked[v] = true;
        //第二步:更新数据
        for (Edge e : G.adj(v)) {
            //1.如果当前顶点v的邻接顶点w已在树中,那么不做处理
            int w = e.other(v);
            if (marked[w]) {
                continue;
            }
            //2.如果当前顶点v的邻接顶点w到最小生成树的最短边的权重大于当前边e的权重,那么需要更新数据
            if (e.weight() < distTo[w]) {
                edgeTo[w] = e;
                distTo[w] = e.weight();
                if (pq.contains(w)) {
                    pq.changeKey(w, e.weight());
                } else {
                    pq.insert(w, e.weight());
                }
            }
        }
    }

    /**
     * 获取最小生成树的所有边
     *
     * @return 存储最小生成树所有边的队列
     */
    public Queue<Edge> edges() {
        //1.创建队列对象allEdges
        Queue<Edge> allEdges = new Queue<>();
        //2.通过遍历数组edgeTo将边添加到队列对象allEdges中
        for (int i = 0; i < edgeTo.length; i++) {
            if (edgeTo[i] != null) {
                allEdges.enqueue(edgeTo[i]);
            }
        }
        return allEdges;
    }
}