package 图;
import java.util.HashSet;
import java.util.Set;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * 不邻接植花
 * 
 * @author x00418543
 * @since 2020年1月10日
 */
public class GardenNoAdj {

    public static void main(String[] args) {
        GardenNoAdj g = new GardenNoAdj();
        int N = 4;
        int[][] paths = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 1 }, { 1, 3 }, { 2, 4 } };
        int[] answer = g.gardenNoAdj(N, paths);
        System.out.println(answer);
    }

    public int[] gardenNoAdj(int N, int[][] paths) {
        int[] answer = new int[N];
        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                // 从1开始
                answer[i - 1] = 1;
                continue;
            }
            Set<Integer> connected = find(i, paths);
            Set<Integer> types = new HashSet<>();
            if (!connected.isEmpty()) {
                for (Integer d : connected) {
                    Integer type = answer[d - 1];
                    if (type != 0) {
                        types.add(type);
                    }
                }
            }
            if (!types.contains(1)) {
                answer[i - 1] = 1;
            } else if (!types.contains(2)) {
                answer[i - 1] = 2;
            } else if (!types.contains(3)) {
                answer[i - 1] = 3;
            } else if (!types.contains(4)) {
                answer[i - 1] = 4;
            }
        }
        return answer;
    }

    public Set<Integer> find(int i, int[][] paths) {
        Set<Integer> s = new HashSet<>();
        for (int[] path : paths) {
            if (path[0] == i) {
                s.add(path[1]);
            } else if (path[1] == i) {
                s.add(path[0]);
            }
        }
        return s;
    }

}
