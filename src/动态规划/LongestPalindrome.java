package 动态规划;
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * 最长回文子串
 * 
 * @author x00418543
 * @since 2020年1月11日
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        String s = "abcda";
        System.out.println(l.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        String longest = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String word = calcLongest(chars, i);
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        for (int f = 1; f < chars.length; f++) {
            String word = calcLongest2(chars, f);
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    private String calcLongest2(char[] chars, int f) {
        String word = "";
        if (chars[f] == chars[f - 1]) {
            word = chars[f - 1] + word + chars[f];
            for (int i = 1; f - 1 - i >= 0 && f + i < chars.length; i++) {
                if (chars[f - 1 - i] == chars[f + i]) {
                    word = chars[f - 1 - i] + word + chars[f + i];
                } else {
                    break;
                }
            }
        }
        return word;
    }

    private String calcLongest(char[] chars, int index) {
        String word = String.valueOf(chars[index]);
        for (int i = 1; index - i >= 0 && index + i < chars.length; i++) {
            if (chars[index - i] == chars[index + i]) {
                word = chars[index - i] + word + chars[index + i];
            } else {
                break;
            }
        }
        return word;
    }

}
