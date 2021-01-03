package com.ikuta.weighted.directedgraph;

public class DirectedEdge {
    /**
     * 起点顶点
     */
    private final int v;
    /**
     * 终点顶点
     */
    private final int w;
    /**
     * 边的权重值
     */
    private final double weight;

    /**
     * 带参构造器
     *
     * @param v      起点顶点
     * @param w      终点顶点
     * @param weight 边的权重值
     */
    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * 获取边的权重值
     *
     * @return 边的权重值
     */
    public double weight() {
        return weight;
    }

    /**
     * 获取有向边的起点
     *
     * @return 有向边的起点
     */
    public int from() {
        return v;
    }

    /**
     * 获取有向边的终点
     *
     * @return 有向边的终点
     */
    public int to() {
        return w;
    }
}
