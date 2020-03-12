package 排序;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 最大间距
 * 
 * @author x00418543
 * @since 2020年1月17日
 */
public class 最大间距164 {

    public static void main(String[] args) {
        最大间距164 z = new 最大间距164();
        int[] nums = { 15252, 16764, 27963, 7817, 26155, 20757, 3478, 22602, 20404, 6739, 16790, 10588, 16521, 6644,
                20880, 15632, 27078, 25463, 20124, 15728, 30042, 16604, 17223, 4388, 23646, 32683, 23688, 12439, 30630,
                3895, 7926, 22101, 32406, 21540, 31799, 3768, 26679, 21799, 23740 };
        System.out.println(z.maximumGap(nums));
    }

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        SortedMap<Integer, Integer> m = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer counts = m.get(nums[i]);
            if (counts == null) {
                m.put(nums[i], 1);
            }
        }
        int max = 0;
        boolean flag = false;
        int num1 = 0;
        Set<Integer> set = m.keySet();
        for (Integer num : set) {
            if (flag) {
                max = Math.max(max, (num - num1));
                num1 = num;
            } else {
                num1 = num;
                flag = true;
            }
        }
        return max;
    }
}
