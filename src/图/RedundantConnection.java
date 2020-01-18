package 图;
import java.util.List;
import java.util.Stack;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * 冗余链接
 * 
 * @author x00418543
 * @since 2020年1月10日
 */
public class RedundantConnection {

    public static void main(String[] args) {
        RedundantConnection r = new RedundantConnection();
        int[][] edges = { { 1, 2 }, { 2, 3 }, { 4, 3 }, { 4, 1 }, { 1, 5 } };
        int[] edge = r.findRedundantConnection(edges);
        System.out.println(edge);
    }

    public int[] findRedundantConnection(int[][] edges) {
        int length = edges.length;
        for (int i = length - 1; i >= 0; i--) {
            int[] edge = edges[i];
            Stack<int[]> stack = new Stack<int[]>();
            stack.push(edge);
            int end = edge[0];
            if (findEnd(edge, end, edges, stack)) {
                if (edge[0] > edge[1]) {
                    int middle = edge[1];
                    edge[1] = edge[0];
                    edge[0] = middle;
                }
                return edge;
            }
        }
        return null;
    }

    private boolean findEnd(int[] edge, int end, int[][] edges, Stack<int[]> useds) {
        int start = edge[1];
        for (int[] next : edges) {
            if ((next[0] == start || next[1] == start) && !used(useds, next)) {
                if (next[1] == start) {
                    next[1] = next[0];
                    next[0] = start;
                }
                if (next[1] == end) {
                    return true;
                } else {
                    useds.push(next);
                    if (findEnd(next, end, edges, useds)) {
                        return true;
                    } else {
                        useds.pop();
                    }
                }
            }
        }
        return false;
    }

    private boolean used(List<int[]> useds, int[] next) {
        for (int[] used : useds) {
            if (used[0] == next[0] && used[1] == next[1]) {
                return true;
            }
        }
        return false;
    }

}
