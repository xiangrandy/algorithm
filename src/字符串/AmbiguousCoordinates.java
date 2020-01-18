package 字符串;
import java.util.ArrayList;
import java.util.List;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * TODO 在此添加类型注释
 * 
 * @author x00418543
 * @since 2020年1月10日
 */
public class AmbiguousCoordinates {

    public static void main(String[] args) {
        AmbiguousCoordinates a = new AmbiguousCoordinates();
        String S = "(123)";
        List<String> l = a.ambiguousCoordinates(S);
        System.out.println(l);
    }

    public List<String> ambiguousCoordinates(String S) {
        List<String> list = new ArrayList<>();
        int length = S.length();
        // 逐个分割
        for (int i = 1; i < length - 2; i++) {
            String left = S.substring(1, i + 1);
            String right = S.substring(i + 1, length - 1);
            // left加小数点
            List<String> leftList = find(left);
            // right加小数点
            List<String> rightList = find(right);
            // leftList和rightList相乘
            for (String l : leftList) {
                for (String r : rightList) {
                    String word = "(" + l + ", " + r + ")";
                    list.add(word);
                }
            }
        }
        return list;
    }

    public List<String> find(String word) {
        List<String> words = new ArrayList<>();
        char[] chars = word.toCharArray();
        if (chars.length == 1) {
            words.add(String.copyValueOf(chars));
            return words;
        }
        char[] chars2 = new char[chars.length + 1];
        for (int i = 0; i < chars2.length - 1; i++) {
            // 组装成数字
            for (int j = 0; j < chars2.length; j++) {
                if (j < i) {
                    chars2[j] = chars[j];
                } else if (j == i) {
                    chars2[j] = '.';
                } else {
                    chars2[j] = chars[j - 1];
                }
            }
            if (isNumber(chars2, true)) {
                words.add(String.copyValueOf(chars2));
            }
        }
        if (isNumber(chars, false)) {
            words.add(String.copyValueOf(chars));
        }
        return words;
    }

    private boolean isNumber(char[] chars2, boolean containsDian) {
        if (containsDian) {
            // 第一位是0则第二位必须是.
            if (chars2[0] == '0' && chars2[1] != '.') {
                return false;
            }
            // 如果是小数则最后一位不能为0
            if (chars2[chars2.length - 1] == '0') {
                return false;
            }
            // 第一位和最后一位不能是.
            if (chars2[0] == '.' || chars2[chars2.length - 1] == '.') {
                return false;
            }
            return true;
        } else {
            // 不含小数
            // 第一位不能是0
            if (chars2[0] == '0') {
                return false;
            }
            return true;
        }
    }

}
