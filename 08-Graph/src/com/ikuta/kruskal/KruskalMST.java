package com.ikuta.kruskal;

import com.ikuta.prim.Edge;
import com.ikuta.AI.undirectedgraph.Queue;
import com.ikuta.weighted.undirectedgraph.WeightedUndirectedGraph;

public class KruskalMST {
    /**
     * 队列[用于存储最小生成树的所有边]
     */
    private Queue<Edge> mst;
    /**
     * 并查集[用于存储顶点的分组情况]
     * 索引号代表顶点
     * 索引值代表父结点
     */
    private UnionFind_Tree_Weighted uf;
    /**
     * 最小优先数组[存储图的所有边]
     */
    private MinPriorityQueue<Edge> pq;

    /**
     * 带参构造器
     *
     * @param G 加权无向图
     */
    public KruskalMST(WeightedUndirectedGraph G) {
        //第一步:初始化成员变量
        this.mst = new Queue<Edge>();
        this.uf = new UnionFind_Tree_Weighted(G.V());
        this.pq = new MinPriorityQueue<>(G.E() + 1);//最小优先队列基于堆实现,而堆的索引0处做废弃处理
        for (Edge e : G.edges()) {
            pq.insert(e);
        }

        //第二步:生成最小生成树
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            //1.获取最小优先数组中的最小权重边
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            //2.如果当前边的两个顶点属于同一分组中,那么这两个顶点处于最小生成树,不需要做处理
            if (uf.connected(v, w)) {
                continue;
            }
            //3.如果当前边的两个顶点不属于同一分组中,那么这两个顶点中有一个顶点不处于最小生成树中
            //通过将两个顶点所属的两棵树合并成一棵树实现将该顶点处于最小生成树中
            uf.union(v, w);
            //4.当前边e放入到最小生成树中
            mst.enqueue(e);
        }
    }

    /**
     * 获取最小生成树的所有边
     *
     * @return 存储最小生成树的所有边的队列
     */
    public Queue<Edge> edges() {
        return mst;
    }
}
