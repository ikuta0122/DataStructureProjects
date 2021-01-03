package com.ikuta.AI.undirectedgraph;

import java.util.Stack;

public class DepthFirstPaths {
    //起点
    private int s;
    //辅助数组[索引表示顶点,值表示当前顶点是否已经被搜索]
    private boolean[] marked;
    //辅助数组[索引表示顶点,值表示当前路径上该顶点的前一个顶点]
    private int[] edgeTo;

    /**
     * 构造深度优先搜索对象
     * 使用深度优先搜索找出G图中起点为s的所有路径
     *
     * @param G 图
     * @param s 起点
     */
    public DepthFirstPaths(AIGraph G, int s) {
        //初始化marked数组
        this.marked = new boolean[G.V()];
        //初始化起点
        this.s = s;
        //初始化edgeTo数组
        this.edgeTo = new int[G.V()];
        dfs(G, s);
    }

    /**
     * 使用深度优先搜索找出G图中v顶点的所有相邻顶点
     *
     * @param G 图
     * @param v 顶点
     */
    private void dfs(AIGraph G, int v) {
        //1.设置当前顶点v的标记为true
        marked[v] = true;
        //2.遍历当前顶点v的邻接表获取其邻接顶点,进行递归搜索
        for (Integer w : G.adj(v)) {
            if (!marked[w]) {
                //3.如果当前顶点v的邻接顶点w没有被搜索过,那么顶点w在该路径上的前一个顶点为顶点v
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    /**
     * 判断顶点是否与起点存在路径
     *
     * @param v 顶点
     * @return 返回true表示当前顶点与起点存在路径, 反之亦然
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * 获取从起点s到指定顶点的路径
     *
     * @param v 顶点
     * @return 返回存储路径经过顶点的栈对象
     */
    public Stack<Integer> pathTo(int v) {
        //0.安全性检验
        if (!hasPathTo(v)) {
            return null;
        }
        //1.创建栈对象[存储路径经过顶点]
        Stack<Integer> path = new Stack<>();
        //2.通过循环从辅助数组edgeTo中获取该路径经过的所有顶点
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        //3.返回存储路径经过顶点的栈对象
        return path;
    }
}
