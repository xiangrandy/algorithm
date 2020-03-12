package 动态规划;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * 正则表达式匹配
 * 
 * @author x00418543
 * @since 2020年1月13日
 */
public class 正则表达式匹配 {

    public static void main(String[] args) {
        正则表达式匹配 z = new 正则表达式匹配();
        String s = "mississippi";
        String p = ".*";
        System.out.println(z.isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            // pattern is empty
            return s.isEmpty();
        }
        // pattern is not empty
        boolean first_match = (!s.isEmpty()) && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {
            // 发现'*'通配符，分两种情况讨论，第一种，忽略当前,继续递归，第二种纳入当前,继续递归
            return (isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p)));
        } else {
            // 没有发现'*'通配符，直接匹配，继续递归
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }

}
