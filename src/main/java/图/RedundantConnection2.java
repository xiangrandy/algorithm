package 图;
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * 冗余连接
 * 
 * @author x00418543
 * @since 2020年1月10日
 */
public class RedundantConnection2 {

    public static void main(String[] args) {
        RedundantConnection2 r = new RedundantConnection2();
        int[][] edges = { { 1, 2 }, { 2, 3 }, { 4, 3 }, { 4, 1 }, { 1, 5 } };
        int[] edge = r.findRedundantConnection(edges);
        System.out.println(edge);
    }

    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return null;
        }
        int[] parent = new int[1005], ans = new int[0];
        for (int[] edge : edges) {// scan edges
            // ==== if two parts have been connected (the same parent), update
            // the answer =======
            // ==== else connect two parts =====
            if (find(parent, edge[0]) == find(parent, edge[1])) {
                ans = edge;
            } else {
                join(parent, edge[0], edge[1]);
            }
        }
        return ans;
    }

    private void join(int[] parent, int a, int b) {
        // to make a and b have the same parent
        parent[find(parent, b)] = find(parent, a);
    }

    private int find(int[] parent, int x) {
        // 3 conditions below:
        // 1) not init, parent is self, return
        // 2) parent is self, return
        // 3) call find parent's parent
        // (parent[x] = ... => cache for faster query)
        return parent[x] == 0 ? (parent[x] = x) : parent[x] == x ? x : (parent[x] = find(parent, parent[x]));
    }

}
