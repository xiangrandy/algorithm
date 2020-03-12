package 数学;
import java.util.Stack;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * TODO 在此添加类型注释
 * 
 * @author x00418543
 * @since 2020年1月13日
 */
public class 整数转罗马数字 {

    public static void main(String[] args) {
        整数转罗马数字 z = new 整数转罗马数字();
        int num = 1000;
        System.out.println(z.intToRoman(num));
    }

    public String intToRoman(int num) {
        String rom = "";
        Stack<String> stack = new Stack<>();
        int lineNum = 1;
        while (num != 0) {
            int rest = num % 10;
            String roman = intToRoman(rest, lineNum);
            if (!"".equals(roman)) {
                stack.add(roman);
            }
            num /= 10;
            lineNum++;
        }
        while (!stack.isEmpty()) {
            rom += stack.pop();
        }
        return rom;
    }

    public String intToRoman(int num, int lineNum) {
        if (lineNum == 1) {
            if (num == 1) {
                return "I";
            } else if (num == 2) {
                return "II";
            } else if (num == 3) {
                return "III";
            } else if (num == 4) {
                return "IV";
            } else if (num == 5) {
                return "V";
            } else if (num == 6) {
                return "VI";
            } else if (num == 7) {
                return "VII";
            } else if (num == 8) {
                return "VIII";
            } else if (num == 9) {
                return "IX";
            } else {
                return "";
            }
        } else if (lineNum == 2) {
            if (num == 1) {
                return "X";
            } else if (num == 2) {
                return "XX";
            } else if (num == 3) {
                return "XXX";
            } else if (num == 4) {
                return "XL";
            } else if (num == 5) {
                return "L";
            } else if (num == 6) {
                return "LX";
            } else if (num == 7) {
                return "LXX";
            } else if (num == 8) {
                return "LXXX";
            } else if (num == 9) {
                return "XC";
            } else {
                return "";
            }
        } else if (lineNum == 3) {
            if (num == 1) {
                return "C";
            } else if (num == 2) {
                return "CC";
            } else if (num == 3) {
                return "CCC";
            } else if (num == 4) {
                return "CD";
            } else if (num == 5) {
                return "D";
            } else if (num == 6) {
                return "DC";
            } else if (num == 7) {
                return "DCC";
            } else if (num == 8) {
                return "DCCC";
            } else if (num == 9) {
                return "CM";
            } else {
                return "";
            }
        } else {
            if (num == 1) {
                return "M";
            } else if (num == 2) {
                return "MM";
            } else if (num == 3) {
                return "MMM";
            } else {
                return "";
            }
        }
    }

}
