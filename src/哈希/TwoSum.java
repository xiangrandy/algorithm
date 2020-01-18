package 哈希;
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * TODO 在此添加类型注释
 * 
 * @author x00418543
 * @since 2020年1月11日
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum t = new TwoSum();
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = t.twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

}
