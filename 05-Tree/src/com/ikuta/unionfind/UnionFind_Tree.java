package com.ikuta.unionfind;

public class UnionFind_Tree {
    /**
     * 记录结点元素和该元素所在分组的标识
     */
    private int[] eleAndGroup;
    /**
     * 记录并查集中数据的分组个数
     */
    private int count;

    /**
     * 初始化并查集
     *
     * @param N 初始化分组数量
     */
    public UnionFind_Tree(int N) {
        //第一步:初始化分组数量[默认有N个分组]
        this.count = N;
        //第二步:初始化数组eleAndGroup
        this.eleAndGroup = new int[N];
        //第三步:初始化数组eleAndGroup中的元素及其父结点
        //1.数组eleAndGroup的索引号--->结点的存储元素
        //2.数组eleAndGroup的索引值--->结点的父结点
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
        }
    }

    /**
     * 获取并查集的分组个数
     *
     * @return 并查集的分组个数
     */
    public int count() {
        return count;
    }

    /**
     * 判断查询两个元素是否属于同一组
     *
     * @param p 待判断元素
     * @param q 待判断元素
     * @return 返回true表示两个元素属于同一组数据, 反之亦然
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 获取元素所在分组的标识符
     *
     * @param p 待查询元素
     * @return 元素所在分组的标识符
     */
    public int find(int p) {
        while (p != eleAndGroup[p]) {
            p = eleAndGroup[p];
        }
        return p;
    }

    /**
     * 合并两个元素所在的组
     *
     * @param p 判断元素
     * @param q 判断元素
     */
    public void union(int p, int q) {
        //第一步:获取元素p和元素p各自树的根结点
        int pRoot = find(p);
        int qRoot = find(q);
        //第二步:判断元素p和元素q是否在同一颗树下
        //1.如果元素p和元素q在同一颗树下,那么直接结束方法
        if (pRoot == qRoot) {
            return;
        }
        //2.如果元素p和元素q不在同一颗树下,那么进行分组合并[一棵树的根结点的父结点设置为另一棵树的根结点]
        eleAndGroup[pRoot] = qRoot;
        //第三步:如果发生分组合并现象,那么分组数量减1
        this.count--;
    }
}