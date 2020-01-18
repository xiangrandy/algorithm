package 深度优先;
import java.util.ArrayList;
import java.util.List;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * 括号生成
 * 
 * @author x00418543
 * @since 2020年1月14日
 */
public class 括号生成 {

    public static void main(String[] args) {
        括号生成 k = new 括号生成();
        int n = 5;
        List<String> l = k.generateParenthesis(n);
        System.out.println(l);
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }
        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }

    private void dfs(String curStr, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }

    public void combine(String generated, int n, List<String> l) {
        if (n == 0) {
            // 检查generated
            if (isValid(generated)) {
                l.add(generated);
            }
            return;
        }
        for (int i = 0; i < 2; i++) {
            // 当前位置要么选择左括号，要么选择右括号
            if (i == 0) {
                // 选择左括号
                String left = generated + "(";
                // 继续拼接
                combine(left, n - 1, l);
            } else {
                // 选择右括号
                String right = generated + ")";
                combine(right, n - 1, l);
            }
        }
    }

    public boolean isValid(String s) {
        char[] current = s.toCharArray();
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return (balance == 0);
    }

}
