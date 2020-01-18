package 数学;
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * 罗马数字转整数
 * 
 * @author x00418543
 * @since 2020年1月13日
 */
public class 罗马数字转整数 {

    public static void main(String[] args) {
        罗马数字转整数 l = new 罗马数字转整数();
        String s = "MCMXCIV";
        System.out.println(l.romanToInt(s));
    }

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int num = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'M') {
                num += 1000;
            } else if (chars[i] == 'D') {
                num += 500;
            } else if (chars[i] == 'C') {
                if ((i + 1 < chars.length) && chars[i + 1] == 'M') {
                    num += 900;
                    i++;
                } else if ((i + 1 < chars.length) && chars[i + 1] == 'D') {
                    num += 400;
                    i++;
                } else {
                    num += 100;
                }
            } else if (chars[i] == 'L') {
                num += 50;
            } else if (chars[i] == 'X') {
                if ((i + 1 < chars.length) && chars[i + 1] == 'C') {
                    num += 90;
                    i++;
                } else if ((i + 1 < chars.length) && chars[i + 1] == 'L') {
                    num += 40;
                    i++;
                } else {
                    num += 10;
                }
            } else if (chars[i] == 'V') {
                num += 5;
            } else if (chars[i] == 'I') {
                if ((i + 1 < chars.length) && chars[i + 1] == 'X') {
                    num += 9;
                    i++;
                } else if ((i + 1 < chars.length) && chars[i + 1] == 'V') {
                    num += 4;
                    i++;
                } else {
                    num += 1;
                }
            }
        }
        return num;
    }

}
