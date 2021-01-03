package com.ikuta.AI.directedgraph;

public class TopoLogical {
    /**
     * 使用栈储存顶点拓扑排序
     */
    private Stack<Integer> order;

    /**
     * 构造拓扑排序对象
     *
     * @param G 有向图
     */
    public TopoLogical(AIDGraph G) {
        //1.创建检测有向环对象
        DepthFirstCheck check = new DepthFirstCheck(G);
        //2.判断有向图是否存在环
        if (!check.hasCycle()) {
            //2.1如果有向图不存在环,那么进行顶点排序[创建顶点排序对象]
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(G);
            order = depthFirstOrder.reversePost();
        }
    }

    /**
     * 判断有向图是否存在环
     *
     * @return 返回true表示有向图中存在环
     */
    private boolean isCycle() {
        return order == null;
    }

    /**
     * 获取顶点拓扑排序的栈
     *
     * @return 顶点拓扑排序的栈
     */
    public Stack<Integer> order() {
        return order;
    }
}
