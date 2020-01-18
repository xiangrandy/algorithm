package 栈;
import java.util.Stack;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * TODO 在此添加类型注释
 * 
 * @author x00418543
 * @since 2020年1月12日
 */
public class 有效的括号 {

    public static void main(String[] args) {
        有效的括号 a = new 有效的括号();
        String s = "()";
        System.out.println(a.isValid(s));
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (stack.isEmpty()) {
                if (c == ')' || c == ']' || c == '}') {
                    return false;
                }
            }
            if (c == ')') {
                char poped = stack.pop();
                if (poped != '(') {
                    return false;
                }
            } else if (c == ']') {
                char poped = stack.pop();
                if (poped != '[') {
                    return false;
                }
            } else if (c == '}') {
                char poped = stack.pop();
                if (poped != '{') {
                    return false;
                }
            } else {
                stack.push(c);
            }

        }
        return stack.isEmpty();
    }

}
