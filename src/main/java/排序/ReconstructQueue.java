package 排序;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO 在此添加类型注释
 * 
 * @author x00418543
 * @since 2020年1月15日
 */
public class ReconstructQueue {

    public static void main(String[] args) {
        ReconstructQueue q = new ReconstructQueue();
        int[][] people = { { 8, 0 }, { 4, 4 }, { 8, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
        int[][] a = q.reconstructQueue(people);
        System.out.println(a);
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // if the heights are equal, compare k-values
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        List<int[]> output = new LinkedList<>();
        for (int[] p : people) {
            output.add(p[1], p);
        }

        int n = people.length;
        return output.toArray(new int[n][2]);
    }

}
