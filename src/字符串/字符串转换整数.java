package 字符串;
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * TODO 在此添加类型注释
 * 
 * @author x00418543
 * @since 2020年1月12日
 */
public class 字符串转换整数 {

    public static void main(String[] args) {
        字符串转换整数 a = new 字符串转换整数();
        String str = "42";
        System.out.println(a.myAtoi(str));
    }

    public int myAtoi(String str) {
        int sum = 0;
        String st = str.trim();
        if (st.length() == 0 || st == null) {
            return 0;
        }
        if (st.charAt(0) == '-') {
            for (int i = 1; i < st.length(); i++) {
                if (st.charAt(i) <= 57 && st.charAt(i) >= 48) {
                    int temp = st.charAt(i) - 48;
                    if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && temp > 7)) {
                        return Integer.MIN_VALUE;
                    } else {
                        sum = sum * 10 + temp;
                    }
                } else {
                    break;
                }

            }
        } else if (st.charAt(0) == '+') {
            for (int i = 1; i < st.length(); i++) {
                if (st.charAt(i) <= 57 && st.charAt(i) >= 48) {
                    int temp = st.charAt(i) - 48;
                    if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && temp > 7)) {
                        return Integer.MAX_VALUE;
                    } else {
                        sum = sum * 10 + temp;
                    }
                } else {
                    break;
                }

            }

        } else if (st.charAt(0) > 48 && st.charAt(0) <= 57) {
            sum = st.charAt(0) - 48;
            for (int i = 1; i < st.length(); i++) {
                if (st.charAt(i) <= 57 && st.charAt(i) >= 48) {
                    int temp = st.charAt(i) - 48;
                    if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && temp > 7)) {
                        return Integer.MAX_VALUE;
                    } else {
                        sum = sum * 10 + temp;
                    }
                } else {
                    break;
                }

            }

        } else if (st.charAt(0) == '0') {
            int i = 1;
            while (i < st.length() && st.charAt(i) == '0') {
                i++;
            }
            if (i < st.length()) {
                String s = st.substring(i, st.length());
                if (s.charAt(0) < 48 || s.charAt(0) > 57) {
                    return 0;
                }
                sum = myAtoi(s);
            } else {
                return 0;
            }
        }
        if (st.charAt(0) == '-') {
            return -1 * sum;
        } else {
            return sum;
        }

    }

}
