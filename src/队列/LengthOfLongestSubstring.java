package 队列;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * TODO 在此添加类型注释
 * 
 * @author x00418543
 * @since 2020年1月11日
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        String s = "pwwkew";
        System.out.println(l.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Queue<Character> q = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (q.contains(c)) {
                // 去除
                while (!q.peek().equals(c)) {
                    q.poll();
                }
                q.poll();
            }
            q.add(c);
            if (q.size() > maxLength) {
                maxLength = q.size();
            }
        }
        return maxLength;
    }

}
