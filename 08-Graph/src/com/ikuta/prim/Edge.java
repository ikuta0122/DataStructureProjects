package com.ikuta.prim;

/**
 * 加权无向图的边使用对象来描述
 */
public class Edge implements Comparable<Edge> {
    /**
     * 顶点1
     */
    private final int v;
    /**
     * 顶点2
     */
    private final int w;
    /**
     * 边的权重值
     */
    private final double weight;

    /**
     * 带参构造器
     *
     * @param v      顶点1
     * @param w      顶点2
     * @param weight 边的权重值
     */
    public Edge(int v, int w, double weight) {
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
     * 获取边上的点
     *
     * @return 顶点
     */
    public int either() {
        return v;
    }

    /**
     * 获取边上的另一个顶点
     *
     * @param vertex 顶点
     * @return 边上的另一个顶点
     */
    public int other(int vertex) {
        return vertex == v ? w : v;
    }

    /**
     * 判断当前边与待比较边的权重值大小
     *
     * @param that 待比较边
     * @return 返回true表示当前边的权重值大于待比较边, 反之亦然
     */
    @Override
    public int compareTo(Edge that) {
        //1.记录比较结果
        int cmp;
        //2.定义比较规则
        //2.1如果两条边的权重值相等,那么cmp = 0
        //2.2如果当前边的权重值更大,那么cmp = 1
        //2.3如果当前边的权重值更小,那么cmp = -1
        if (this.weight() == that.weight()) {
            cmp = 0;
        } else {
            cmp = this.weight() > that.weight() ? 1 : -1;
        }
        return cmp;
    }
}
