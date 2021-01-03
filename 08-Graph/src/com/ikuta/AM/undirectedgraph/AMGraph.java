package com.ikuta.AM.undirectedgraph;

import java.util.LinkedList;
import java.util.Scanner;

public class AMGraph {
    private String[] vexs = null;//点集信息
    private int[][] arcs = null;//边集信息
    private boolean[] visited = null;//访问信息

    public AMGraph(int vexNum, int arcNum) {//输入点的个数和边的个数
        this.vexs = new String[vexNum];
        this.arcs = new int[vexNum][vexNum];
        System.out.print("请依次输入顶点值，以空格隔开：");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < vexNum; i++) {//根据输入建立点集
            this.vexs[i] = sc.next();
        }

        for (int i = 0; i < vexNum; i++) {//初始化边集
            for (int j = 0; j < vexNum; j++) {
                this.arcs[i][j] = 0;
            }
        }

        start:
        for (int i = 0; i < arcNum; i++) {//开始建立边集
            sc = new Scanner(System.in);
            int vex1Site = 0;
            int vex2Site = 0;
            String vex1;
            String vex2;

            System.out.print("请输入第" + (i + 1) + "条边所依附的两个顶点，以空格隔开：");
            vex1 = sc.next();
            vex2 = sc.next();
            //查找输入的第一个顶点的位置
            for (int j = 0; j < this.vexs.length; j++) {
                if (this.vexs[j].equals(vex1)) {
                    vex1Site = j;
                    break;
                }
                if (j == this.vexs.length - 1) {
                    System.out.println("未找到第一个顶点，请重新输入！");
                    i--;
                    continue start;
                }
            }
            //查找输入的第二个顶点的位置
            for (int j = 0; j < this.vexs.length; j++) {
                if (this.vexs[j].equals(vex2)) {
                    vex2Site = j;
                    break;
                }
                if (j == this.vexs.length - 1) {
                    System.out.println("未找到第二个顶点，请重新输入！");
                    i--;
                    continue start;
                }
            }
            //检测该边是否已经输入
            if (this.arcs[vex1Site][vex2Site] != 0) {
                System.out.println("该边已存在！");
                i--;
                continue start;
            } else {
                this.arcs[vex1Site][vex2Site] = 1;
                this.arcs[vex2Site][vex1Site] = 1;
            }
        }
        System.out.println("基于邻接矩阵的无向图创建成功！");
        sc.close();
    }

    public void dFSTraverse() {
        //初始化访问标志数组
        this.visited = new boolean[this.vexs.length];
        for (int i = 0; i < this.visited.length; i++) {
            this.visited[i] = false;
        }
        //对未访问的顶点调用深度优先遍历算法
        for (int i = 0; i < this.visited.length; i++) {
            if (!this.visited[i]) {
                dFS_AM(i);
            }
        }
    }

    public void dFS_AM(int site) {//输入深度优先遍历的开始顶点
        //记录遍历过程
        System.out.print(this.vexs[site] + " ");
        //1.设置当前顶点的访问标记为true
        this.visited[site] = true;
        //2.通过深度优先遍历算法依次查找未访问邻接点
        for (int i = 0; i < this.vexs.length; i++) {
            if (this.arcs[site][i] != 0 && !this.visited[i]) {
                this.dFS_AM(i);
            }
        }
    }

    public void bFSTraverse() {
        //初始化访问标志数组
        this.visited = new boolean[this.vexs.length];
        for (int i = 0; i < this.visited.length; i++) {
            this.visited[i] = false;
        }
        //对未访问的顶点调用广度优先遍历算法
        for (int i = 0; i < this.visited.length; i++) {
            if (!this.visited[i]) {
                bFS_AM(i);
            }
        }
    }

    public void bFS_AM(int site) {//输入广度优先遍历的开始顶点
        //记录遍历过程
        System.out.print(this.vexs[site] + " ");
        //1.设置当前顶点的访问标记为true
        this.visited[site] = true;
        //2.初始化辅助队列
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        //3.当前顶点进入队列
        linkedList.offer(site);
        //4.通过循环不断从队列中获取待访问顶点,直至队列为空
        while (!linkedList.isEmpty()) {
            //4.1获取待访问顶点
            int vexSite = linkedList.poll();
            //4.2获取待访问顶点的邻接顶点
            for (int i = 0; i < this.vexs.length; i++) {
                if (this.arcs[vexSite][i] != 0 && !this.visited[i]) {
                    //记录遍历过程
                    System.out.print(this.vexs[i] + " ");
                    this.visited[i] = true;
                    linkedList.offer(i);
                }
            }
        }
    }
}