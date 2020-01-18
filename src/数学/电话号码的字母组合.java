package 数学;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * 
 * @author x00418543
 * @since 2020年1月14日
 */
public class 电话号码的字母组合 {

    public static void main(String[] args) {
        电话号码的字母组合 d = new 电话号码的字母组合();
        String digits = "23333";
        System.out.println(d.letterCombinations(digits));
    }

    public List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<>();
        if ("".equals(digits.trim())) {
            return output;
        }
        char[][] mappers = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
                { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };
        int[] countMapper = { 0, 0, 3, 3, 3, 3, 3, 4, 3, 4 };
        char[] digitArr = digits.toCharArray();
        List<char[]> digitsMappers = new ArrayList<>(digitArr.length);
        int[] digitsCountMapper = new int[digitArr.length];
        for (int i = 0; i < digitArr.length; i++) {
            int index = digitArr[i] - '0';
            char[] mapper = mappers[index];
            int count = countMapper[index];
            digitsMappers.add(mapper);
            digitsCountMapper[i] = count;
        }
        int[] start = new int[digitArr.length];
        do {
            String print = print(digitsMappers, start);
            output.add(print);
        } while (plus(start, digitsCountMapper));
        return output;
    }

    public String print(List<char[]> digitsMappers, int[] start) {
        String word = "";
        for (int i = 0; i < start.length; i++) {
            word += digitsMappers.get(i)[start[i]];
        }
        return word;
    }

    public boolean plus(int[] start, int[] digitsCountMapper) {
        boolean jinwei = false;
        for (int i = start.length - 1; i >= 0; i--) {
            if ((digitsCountMapper[i] - start[i]) > 1) {
                // 本位加一
                start[i] = start[i] + 1;
                return true;
            } else {
                // 进位，本位置0
                jinwei = true;
                start[i] = 0;
            }
            if (!jinwei) {
                break;
            } else {
                if (i == 0) {
                    return false;
                }
            }
        }
        return false;
    }

}
