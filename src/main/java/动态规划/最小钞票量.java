/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

package 动态规划;

/**
 * TODO 在此添加类型注释
 * 
 * @author x00418543
 * @since 2020年1月16日
 */
public class 最小钞票量 {

    static int[] f = new int[105];
    static int i, n, cost;

    public static void main(String[] args) {
        int n = 15;
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            cost = 1000;
            if (i - 11 >= 0) {
                cost = Math.min(cost, f[i - 11] + 1);
            }
            if (i - 5 >= 0) {
                cost = Math.min(cost, f[i - 5] + 1);
            }
            if (i - 1 >= 0) {
                cost = Math.min(cost, f[i - 1] + 1);
            }
            f[i] = cost;
            System.out.println(i + " " + f[i]);
        }

    }

}
