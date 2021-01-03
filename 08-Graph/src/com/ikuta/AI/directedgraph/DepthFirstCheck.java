package com.ikuta.AI.directedgraph;

public class DepthFirstCheck {
    /**
     * 辅助数组[搜索标记]
     * 索引代表顶点,值表示当前顶点是否已经被搜索
     */
    private boolean[] searched;
    /**
     * 记录图中是否有环
     */
    private boolean hasCycle;
    /**
     * 辅助数组[路径标记]
     * 索引代表顶点,值表示当前顶点是否处于正在搜索的有向路径上
     */
    private boolean[] onPath;

    /**
     * @param G 有向图
     */
    public DepthFirstCheck(AIDGraph G) {
        //1.初始化searched数组
        this.searched = new boolean[G.V()];
        //2.初始化hasCycle
        this.hasCycle = false;
        //3.初始化数组onPath
        this.onPath = new boolean[G.V()];
        //4.遍历图的顶点[以当前顶点为起点调用dfs()方法]
        for (int v = 0; v < G.V(); v++) {
            if (!searched[v]) {
                dfs(G, v);
            }
        }
    }

    /**
     * 判断有向环是否存在环
     *
     * @return 返回true表示有向图存在环, 反之亦然
     */
    public boolean hasCycle() {
        return hasCycle;
    }

    /**
     * 通过深度优先搜索判断指定有向图中以指定顶点为起点是否存在环
     * <p>
     * 搜索标记被设置为true,无法恢复为false
     * 路径标记被设置为true,会在方法结束后恢复为false
     * <p>
     * 假设已经搜索到有向图最后一个顶点,此时没有将其路径标记恢复为false就结束递归
     * 那么前一个顶点的onPath[最后一个顶点]永远为true,从而导致hasCycle永远为true
     *
     * @param G 有向图
     * @param v 起点
     */
    private void dfs(AIDGraph G, int v) {
        //1.设置当前顶点v的搜索标记为true
        searched[v] = true;
        //2.设置当前顶点v的路径标记为true
        onPath[v] = true;
        //3.判断当前顶点v为起点的路径是否存在环
        for (Integer w : G.adj(v)) {
            //3.1如果当前顶点w没有被搜索过,那么继续递归调用dfs()方法
            if (!searched[w]) {
                dfs(G, w);
            }
            //3.2如果当前顶点w已经在栈中,那么当前结点已经处于正在搜索的当前路径上
            //当前结点处于正在搜索的当前路径上表示当前路径存在环
            if (onPath[w]) {
                hasCycle = true;
                return;
            }
        }
        //4.设置当前顶点v的路径标记为false
        onPath[v] = false;
    }
}
