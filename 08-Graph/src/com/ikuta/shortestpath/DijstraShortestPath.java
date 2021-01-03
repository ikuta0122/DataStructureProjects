package com.ikuta.shortestpath;

import com.ikuta.AI.undirectedgraph.Queue;
import com.ikuta.prim.IndexMinPriorityQueue;
import com.ikuta.weighted.directedgraph.DirectedEdge;
import com.ikuta.weighted.directedgraph.WeightedDirectedGraph;

public class DijstraShortestPath {
    /**
     * 辅助数组[存储起点顶点到当前顶点的最短路径上的最后一条边]
     * 索引号表示顶点
     * 索引值表示起点顶点到当前顶点的最短路径上的最后一条边
     */
    private DirectedEdge[] edgeTo;
    /**
     * 辅助数组[存储起点顶点到当前顶点的最短路径的总权重]
     * 索引号表示顶点
     * 索引值表示起点顶点到当前顶点的最短路径的总权重
     */
    private double[] distTo;
    //存放树中顶点与非树中顶点之间的有效横切边
    /**
     * 辅助队列[存储非树中顶点和树中顶点之间的有效横切边]
     */
    private IndexMinPriorityQueue<Double> pq;

    /**
     * 带参构造器
     *
     * @param G 加权有向图
     * @param s 顶点
     */
    public DijstraShortestPath(WeightedDirectedGraph G, int s) {
        //1.初始化成员变量
        this.edgeTo = new DirectedEdge[G.V()];
        this.distTo = new double[G.V()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        this.pq = new IndexMinPriorityQueue<>(G.V());
        //2.生成最短路径树
        distTo[s] = 0.0;
        pq.insert(s, 0.0);
        while (!pq.isEmpty()) {
            relax(G, pq.delMin());
        }
    }

    /**
     * 顶点松弛
     *
     * @param G 加权有向图
     * @param v 顶点
     */
    private void relax(WeightedDirectedGraph G, int v) {
        for (DirectedEdge edge : G.adj(v)) {
            //1.获取边的终点w
            int w = edge.to();
            //2.通过松弛技术判断从起点s到顶点w的路径是否为最短路径
            if (distTo(v) + edge.weight() < distTo(w)) {
                //如果从起点s到顶点w的路径不是最短路径,那么需要更新数据
                //2.1更新辅助数组distTo和edgeTo
                distTo[w] = distTo[v] + edge.weight();
                edgeTo[w] = edge;
                //2.2更新辅助队列pq[用于形成循环]
                if (pq.contains(w)) {
                    pq.changeKey(w, distTo(w));
                } else {
                    pq.insert(w, distTo(w));
                }
            }
        }
    }

    /**
     * 获取从顶点s到顶点v的最短路径的总权重
     *
     * @param v 顶点
     * @return 从顶点s到顶点v的最短路径的总权重
     */
    public double distTo(int v) {
        return distTo[v];
    }

    /**
     * 判断从顶点s到顶点v是否可达
     *
     * @param v 顶点
     * @return 返回true表示从顶点s到顶点v是否可达, 反之亦然
     */
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    /**
     * 获取从起点s到顶点v的最短路径的所有边
     *
     * @param v 终点顶点
     * @return 存储从起点s到顶点v的最短路径的所有边的队列
     */
    public Queue<DirectedEdge> pathTo(int v) {
        //1.判断从顶点s到顶点v是否可达
        if (!hasPathTo(v)) {
            return null;
        }
        //2.遍历辅助数组edgeTo,将最短路径上的所有边放入到队列allEdges中
        Queue<DirectedEdge> allEdges = new Queue<>();
        while (true) {
            DirectedEdge e = edgeTo[v];
            if (e == null) {
                break;
            }
            allEdges.enqueue(e);
            v = e.from();
        }
        return allEdges;
    }
}
