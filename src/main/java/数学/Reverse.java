package 数学;
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * 整数反转
 * 
 * @author x00418543
 * @since 2020年1月12日
 */
public class Reverse {

    public static void main(String[] args) {
        Reverse r = new Reverse();
        int x = 1534236469;
        System.out.println(r.reverse(x));
    }

    public int reverse(int x) {
        long reversed = 0;
        while (x != 0) {
            int last = x % 10;
            reversed = reversed * 10 + last;
            if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return (int) reversed;
    }
}
