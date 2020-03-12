package 字符串;
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * TODO 在此添加类型注释
 * 
 * @author x00418543
 * @since 2020年1月13日
 */
public class 最长公共前缀 {

    public static void main(String[] args) {
        最长公共前缀 z = new 最长公共前缀();
        String[] strs = {};
        System.out.println(z.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String s = "";
        char c;
        f: for (int i = 0; i < strs[0].length(); i++) {
            c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    break f;
                }
            }
            s += c;
        }
        return s;
    }

}
