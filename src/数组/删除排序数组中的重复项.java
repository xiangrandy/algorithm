/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

package 数组;

/**
 * 删除排序数组中的重复项
 * 
 * @author x00418543
 * @since 2020年1月15日
 */
public class 删除排序数组中的重复项 {

    public static void main(String[] args) {
        删除排序数组中的重复项 s = new 删除排序数组中的重复项();
        int[] nums = { 1, 1 };
        int length = s.removeDuplicates(nums);
        System.out.println(length);
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1) {
                if (nums[i] != nums[i + 1]) {
                    nums[index] = nums[i];
                    index++;
                }
            } else {
                if (nums[i - 1] != nums[i]) {
                    nums[index] = nums[i];
                    index++;
                } else {
                    if (index == 0) {
                        index++;
                    }
                }
                break;
            }
        }
        return index;
    }

}
