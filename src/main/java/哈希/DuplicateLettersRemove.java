/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

package 哈希;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 
 * @author x00418543
 * @since 2020年1月15日
 */
public class DuplicateLettersRemove {

    public static void main(String[] args) {
        DuplicateLettersRemove r = new DuplicateLettersRemove();
        String s = "bbcaac";
        long start = System.currentTimeMillis();
        System.out.println(r.removeDuplicateLetters(s));
        System.out.println(System.currentTimeMillis() - start);
    }

    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }
        String minWord = "";
        char[] chars = s.toCharArray();
        Map<Character, List<Integer>> dict = parseMap(chars);
        Set<Character> set = parseSet(dict);
        Map<Character, Integer> used = new HashMap<>();
        int curIndex = -1;
        s: while (used.size() != set.size()) {
            for (Character c : set) {
                if (used.get(c) != null) {
                    continue;
                }
                // 获取c的索引列表
                List<Integer> l = dict.get(c);
                // 折半查找
                int index = findIndex(l, curIndex);
                if (index != -1 && isOk(c, index, set, used, dict)) {
                    // 如果可以使用则将curIndex设置为index
                    curIndex = index;
                    // used中加入c
                    used.put(c, 1);
                    minWord += c;
                    continue s;
                }
            }
        }
        return minWord;
    }

    private Map<Character, List<Integer>> parseMap(char[] chars) {
        Map<Character, List<Integer>> dict = new HashMap<>(64);
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            List<Integer> listOfC = dict.get(c);
            if (listOfC == null) {
                List<Integer> l = new ArrayList<>(16);
                l.add(i);
                dict.put(c, l);
            } else {
                listOfC.add(i);
            }
        }
        return dict;
    }

    private Set<Character> parseSet(Map<Character, List<Integer>> dict) {
        Set<Character> set = new HashSet<>();
        for (Character c : dict.keySet()) {
            set.add(c);
        }
        return set;
    }

    private int findIndex(List<Integer> l, int curIndex) {
        for (Integer index : l) {
            // 遍历索引列表
            if (index > curIndex) {
                // 如果i大于当前索引值，则获取当前索引值，判断当前索引值是否可以使用
                return index;
            }
        }
        return -1;
    }

    private boolean isOk(Character c, int index, Set<Character> set, Map<Character, Integer> used,
            Map<Character, List<Integer>> dict) {
        for (Character ch : set) {
            if (used.get(ch) != null) {
                continue;
            }
            if (ch == c) {
                continue;
            }
            List<Integer> l = dict.get(ch);
            if (l.get(l.size() - 1) > index) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

}
