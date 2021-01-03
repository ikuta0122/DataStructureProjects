package com.ikuta.AI.undirectedgraph;

public class DepthFirstSearch {
    /**
     * 记录顶点状态的数组
     * 因为在邻接表中索引号表示顶点,所以通过给索引号打标记的方式记录当前顶点是否已经被搜索
     */
    private boolean[] marked;
    /**
     * 记录目标顶点的相通顶点个数
     */
    private int count;

    /**
     * 无参构造方法
     */
    public DepthFirstSearch() {
    }

    /**
     * 带参构造方法
     *
     * @param G 目标图
     * @param v 目标顶点
     */
    public DepthFirstSearch(AIGraph G, int v) {
        //1.初始化marked数组
        this.marked = new boolean[G.V()];
        //2.初始化当前顶点v的相通顶点个数
        this.count = -1;
        //3.使用深度优先搜索算法获取G图中顶点v的所有相通顶点
        dfs(G, v);
    }

    /**
     * 判断当前顶点是否被搜索过
     *
     * @param w 目标顶点
     * @return 返回true表示目标顶点已经被搜索过, 反之亦然
     */
    public boolean marked(int w) {
        return marked[w];
    }

    /**
     * 获取目标顶点的相通顶点个数
     *
     * @return 目标顶点的相通顶点个数
     */
    public int count() {
        return count;
    }

    /**
     * 获取G图中顶点v的所有相通顶点
     *
     * @param G 目标图
     * @param v 目标顶点
     */
    private void dfs(AIGraph G, int v) {
        //0.安全性检验
        if (G.adj(v) == null) {
            return;
        }
        //1.设置当前顶点v的boolean标记为true
        marked[v] = true;
        //2.通过遍历顶点v的所有相邻顶点,获取并深度优先搜索没有被搜索过的相邻顶点
        //思想:优先搜索相邻顶点的子结点而非兄弟结点
        for (Integer w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        //3.顶点v的相通顶点个数+1
        count++;
    }
}
