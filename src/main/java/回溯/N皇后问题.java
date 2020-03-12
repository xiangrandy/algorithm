package 回溯;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * N皇后问题
 * 
 * @author x00418543
 * @since 2020年1月16日
 */
public class N皇后问题 {
    // output
    List<List<String>> output = new ArrayList<>();

    int n;
    // queens positions
    Stack<Integer> queens;

    public static void main(String[] args) {
        N皇后问题 q = new N皇后问题();
        int n = 13;
        List<List<String>> solution = q.solveNQueens(n);
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        queens = new Stack<>();
        backtrack(0);
        return output;
    }

    public void backtrack(int row) {
        for (int col = 0; col < n; col++) {
            // 安全
            if (isNotUnderAttack(row, col)) {
                // 放置Q
                queens.add(col);
                if (row + 1 == n) {
                    // 已经放置了N个皇后
                    addSolution();
                } else {
                    // 回溯
                    backtrack(row + 1);
                }
                // 移除Q
                queens.pop();
            }
        }
    }

    public boolean isNotUnderAttack(int row, int col) {
        for (int i = 0; i < queens.size(); i++) {
            int j = queens.get(i);
            if (j == col || i == row || Math.abs(j - col) == Math.abs(row - i)) {
                return false;
            }
        }
        return true;
    }

    public void addSolution() {
        List<String> solution = new ArrayList<String>();
        for (int i = 0; i < n; ++i) {
            int col = queens.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < col; ++j)
                sb.append(".");
            sb.append("Q");
            for (int j = 0; j < n - col - 1; ++j)
                sb.append(".");
            solution.add(sb.toString());
        }
        output.add(solution);
    }

}
