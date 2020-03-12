package 哈希;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 三数之和
 * 
 * @author x00418543
 * @since 2020年1月13日
 */
public class 三数之和 {

    public static void main(String[] args) {
        三数之和 s = new 三数之和();
        int[] nums = { 0 };
        System.out.println(s.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.get(num) != null) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        Set<Integer> set = map.keySet();
        for (int i : set) {
            for (int j : set) {
                int k = 0 - i - j;
                int times = map.get(k) == null ? 0 : map.get(k);
                if (i == j && j == k) {
                    // i,j,k相等
                    if (k == 0 && times >= 3) {
                        // 都为0，且次数大于3
                        result.add(combine(i, j, k));
                    }
                } else if (i == j && j != k) {
                    // i,j相等
                    if (map.get(i) >= 2 && times > 0) {
                        // i次数大于等于2且k次数大于0
                        result.add(combine(i, j, k));
                    }
                } else if (i != j) {
                    // i不等于j
                    if ((k == i || k == j)) {
                        // k等于i或k==j且k次数大于2
                        if (times >= 2) {
                            result.add(combine(i, j, k));
                        }
                    } else {
                        // k不等于i，k不等于j
                        if (times > 0) {
                            result.add(combine(i, j, k));
                        }
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    public List<Integer> combine(int i, int j, int k) {
        List<Integer> l = new ArrayList<>();
        l.add(i);
        l.add(j);
        l.add(k);
        Collections.sort(l);
        return l;
    }

}
