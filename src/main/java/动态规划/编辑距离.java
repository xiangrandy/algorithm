/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

package 动态规划;

/**
 * 编辑距离
 * 
 * @author x00418543
 * @since 2020年1月16日
 */
public class 编辑距离 {

    public static void main(String[] args) {
        编辑距离 b = new 编辑距离();
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(b.minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        int s1 = word1.length();
        int s2 = word2.length();
        int[][] dp = new int[s1 + 1][s2 + 1];
        dp[0][0] = 0;
        // 第一列
        for (int i = 1; i <= s1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        // 第一行
        for (int j = 1; j <= s2; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }
        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[s1][s2];
    }

}
