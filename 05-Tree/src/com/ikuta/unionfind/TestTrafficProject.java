package com.ikuta.unionfind;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestTrafficProject {
    public static void main(String[] args) throws Exception {
        //第一步:读取traffic_project.txt文件[缓冲读取流]
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(TestTrafficProject.class.getClassLoader().getResourceAsStream("com/ikuta/unionfind/conf/traffic_project.txt")));

        //第二步:创建并查集对象
        int cityNumbers = Integer.parseInt(bufferedReader.readLine());
        UnionFind_Tree_Weighted uf = new UnionFind_Tree_Weighted(cityNumbers);

        //第三步:配置文件信息录入[已经修建数量]
        int buildedRoadNumbers = Integer.parseInt(bufferedReader.readLine());
        for (int i = 1; i <= buildedRoadNumbers; i++) {
            String line = bufferedReader.readLine();
            String[] str = line.split(" ");
            int p = Integer.parseInt(str[0]);
            int q = Integer.parseInt(str[1]);
            uf.union(p, q);
        }

        //第四步:获取需要修建数量[需要修建数量  = 分组数量 - 1]
        int neededRoads = uf.count() - 1;
        System.out.println("需要修建" + neededRoads + "条道路");
    }
}
