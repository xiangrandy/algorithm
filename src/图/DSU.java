package 图;
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * 并查集，找老大，如果两个的老大不一样，则将其连起来。 如果老大一样，则表示是自己人，实际上形成了环
 * 
 * @author x00418543
 * @since 2020年1月10日
 */
public class DSU {

    int[] parent;

    public DSU(int total) {
        parent = new int[total + 1];
        for (int i = 0; i <= total; i++) {
            parent[i] = i;
        }
    }

    // 找 root
    public int find(int x) {
        while (x != parent[x]) {
            x = parent[parent[x]];
        }
        return x;
    }

    // 是否有相同的root
    public boolean isConnect(int x, int y) {
        return find(x) == find(y);
    }

    // 合并区域
    public void unionArea(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        parent[rootY] = rootX;
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2];
        // 创建并查集
        DSU union = new DSU(edges.length);
        // 先把第一条线段， 加入到集合中
        union.unionArea(edges[0][0], edges[0][1]);
        for (int i = 1; i < edges.length; i++) {
            // 判断是否相连
            if (union.isConnect(edges[i][0], edges[i][1])) {
                // 如果相连，表示是环，记录下来
                res[0] = edges[i][0];
                res[1] = edges[i][1];
            } else {
                // 如果不相连，则将两者union
                union.unionArea(edges[i][0], edges[i][1]);
            }
        }
        // 返回最后相连的记录
        return res;
    }

    public static void main(String[] args) {
        int[][] edges = { { 1, 2 }, { 2, 3 }, { 4, 3 }, { 4, 1 }, { 1, 5 } };
        int[] res = findRedundantConnection(edges);
        System.out.println(res);
    }

}
