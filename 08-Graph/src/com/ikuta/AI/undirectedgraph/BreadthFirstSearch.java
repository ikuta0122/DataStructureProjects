package com.ikuta.AI.undirectedgraph;

public class BreadthFirstSearch {
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
     * 辅助队列[用于存储待搜索顶点]
     */
    private Queue<Integer> waitSearch;

    /**
     * 无参构造方法
     */
    public BreadthFirstSearch() {
    }

    /**
     * 带参构造方法
     *
     * @param G 目标图
     * @param v 目标顶点
     */
    public BreadthFirstSearch(AIGraph G, int v) {
        //1.初始化marked数组
        this.marked = new boolean[G.V()];
        //2.初始化当前顶点s的相通顶点个数
        this.count = 0;
        //3.初始化辅助队列
        this.waitSearch = new Queue<Integer>();
        //4.使用广度优先搜索算法获取G图中顶点v的所有相通顶点
        bfs(G, v);
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
    private void bfs(AIGraph G, int v) {
        //0.安全性检验
        if (G.adj(v) == null) {
            return;
        }
        //1.把当前顶点v标识为已搜索
        marked[v] =true;
        //2.让当前顶点v作为待搜索进入辅助队列
        waitSearch.enqueue(v);
        //记录广度优先搜索过程
        System.out.print("节点" + v + "广度遍历顺序为：" + v);
        //3.通过循环不断从辅助队列中弹出待搜索顶点,直至辅助队列为空
        while (!waitSearch.isEmpty()) {
            //3.1从辅助队列中获取一个待搜索顶点wait
            Integer wait = waitSearch.dequeue();
            //3.2遍历顶点wait的邻接表
            for (Integer w : G.adj(wait)) {
                if (!marked(w)) {
                    marked[w] =true;
                    waitSearch.enqueue(w);
                    //4.顶点v的相通顶点个数+1
                    count++;
                    //记录广度优先搜索过程
                    System.out.print(" " + w);
                }
            }
        }
        //记录广度优先搜索过程
        System.out.println();
    }
}
