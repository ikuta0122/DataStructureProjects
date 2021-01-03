package com.ikuta.unionfind;

public class UnionFind {
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
    public UnionFind(int N) {
        //第一步:初始化分组数量[默认有N个分组]
        this.count = N;
        //第二步:初始化数组eleAndGroup
        this.eleAndGroup = new int[N];
        //第三步:初始化数组eleAndGroup中的元素及其所在组的标识符
        //1.数组eleAndGroup的索引号--->结点的存储元素
        //2.数组eleAndGroup的索引值--->结点的所在分组
        //3.初始化情况下一个元素一个分组--->索引值就是索引号
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
     * 获取元素所在分组的标识符
     *
     * @param p 待查询元素
     * @return 元素所在分组的标识符
     */
    public int find(int p) {
        return eleAndGroup[p];
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
     * 合并两个元素所在的组
     *
     * @param p 判断元素
     * @param q 判断元素
     */
    public void union(int p, int q) {
        //第一步:安全性检验
        //1.如果判断元素q和p属于同一分组,那么直接结束方法
        if (connected(p, q)) {
            return;
        }
        //2.如果判断元素q和p不属于同一分组,那么进行合并分组

        //第二步:在不属于同一分组的基础上进行合并分组
        //1.找到判断元素p所在分组的标识符
        int pGroup = find(p);
        //2.找到判断元素q所在分组的标识符
        int qGroup = find(q);
        //3.合并分组[将一组数据的所有元素的组标识符设置为另一组数据的组标识符]
        for (int i = 0; i < eleAndGroup.length; i++) {
            if (eleAndGroup[i] == pGroup) {
                eleAndGroup[i] = qGroup;
            }
        }
        //第三步:分组个数减1
        this.count--;
    }
}
