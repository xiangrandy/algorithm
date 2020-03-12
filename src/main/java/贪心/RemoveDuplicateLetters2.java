/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

package 贪心;

import java.util.Stack;

/**
 * 贪心
 * 
 * @author x00418543
 * @since 2020年1月16日
 */
public class RemoveDuplicateLetters2 {

    public static void main(String[] args) {
        RemoveDuplicateLetters2 r = new RemoveDuplicateLetters2();
        String s = "cbacdcbc";
        System.out.println(r.removeDuplicateLetters(s));
    }

    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            // 1
            if (stack.contains(c)) {
                continue;
            }
            // 2
            while (!stack.isEmpty() && stack.peek() > c && s.indexOf(stack.peek(), i) != -1) {
                stack.pop();
            }
            stack.push(c);
        }
        char[] res = new char[stack.size()];
        for (int i = 0; i < stack.size(); i++)
            res[i] = stack.get(i);
        return new String(res);
    }

}
