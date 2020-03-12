package 栈;

import java.util.Stack;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * 逆波兰表达式求值
 * 
 * @author x00418543
 * @since 2020年1月11日
 */
public class EvalPRN {

    public static void main(String[] args) {
        EvalPRN e = new EvalPRN();
        String[] tokens = { "2", "1", "+", "3", "*" };
        System.out.println(e.evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        for (String token : tokens) {
            if (isNumber(token)) {
                Integer number = Integer.parseInt(token);
                numbers.push(number);
            } else {
                Integer second = numbers.pop();
                Integer first = numbers.pop();
                Integer result = calc(first, second, token);
                numbers.push(result);
            }
        }
        return numbers.pop();

    }

    private Integer calc(Integer first, Integer second, String token) {
        if (token.equals("+")) {
            return first + second;
        } else if (token.equals("-")) {
            return first - second;
        } else if (token.equals("*")) {
            return first * second;
        } else if (token.equals("/")) {
            return first / second;
        } else {
            return null;
        }
    }

    private boolean isNumber(String token) {
        if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
            return false;
        }
        return true;
    }

}
