package com.ikuta.AI.directedgraph;

public class DepthFirstOrder {
    /**
     * 辅助数组[顶点的搜索标记]
     */
    private boolean[] searched;
    /**
     * 使用栈储存顶点排序
     */
    private Stack<Integer> reversePost;

    /**
     * 使用深度优先搜索算法判断有向图是否存在环
     *
     * @param G 有向图
     */
    public DepthFirstOrder(AIDGraph G) {
        //1.初始化数组searched
        this.searched = new boolean[G.V()];
        //2.初始化栈reversePost
        this.reversePost = new Stack<Integer>();
        //3.遍历图的顶点,通过深度优先搜索算法判断以当前路径出发的路径是否存在环
        for (int v = 0; v < G.V(); v++) {
            if (!searched[v]) {
                dfs(G, v);
            }
        }
    }

    /**
     * 通过深度优先搜索算法判断以当前路径出发的路径是否存在环
     *
     * @param G 有向图
     * @param v 顶点
     */
    private void dfs(AIDGraph G, int v) {
        //1.设置当前顶点的搜索标记为true
        searched[v] = true;
        //2.当前顶点的邻接顶点递归调用dfs()方法
        for (Integer w : G.adj(v)) {
            if (!searched[w]) {
                dfs(G, w);
            }
        }
        //3.当前顶点v进栈
        reversePost.push(v);
    }

    /**
     * 获取线性排序顶点的栈
     *
     * @return 存储线性排序顶点的栈
     */
    public Stack<Integer> reversePost() {
        return reversePost;
    }
}
