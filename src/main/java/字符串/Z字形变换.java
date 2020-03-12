package 字符串;
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * TODO 在此添加类型注释
 * 
 * @author x00418543
 * @since 2020年1月11日
 */
public class Z字形变换 {

    public static void main(String[] args) {
        Z字形变换 z = new Z字形变换();
        String s = "A";
        int numRows = 1;
        String w = z.convert(s, numRows);
        System.out.println(w);
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        String word = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < numRows; i++) {
            int index = i;
            boolean flag = true;
            while (index < chars.length) {
                char c = chars[index];
                word += c;
                if (i == 0 || (i == numRows - 1)) {
                    index += 2 * (numRows - 1);
                } else {
                    if (flag) {
                        index += 2 * (numRows - 1 - i);
                        flag = false;
                    } else {
                        index += 2 * i;
                        flag = true;
                    }
                }

            }
        }
        return word;
    }

}
