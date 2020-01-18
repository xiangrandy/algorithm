/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

package 哈希;

import java.util.Arrays;

/**
 * TODO 在此添加类型注释
 * 
 * @author x00418543
 * @since 2020年1月13日
 */
public class 最接近的三数之和 {

    public static void main(String[] args) {
        最接近的三数之和 z = new 最接近的三数之和();
        int[] nums = { -1, 2, 1, -4 };
        int target = 1;
        System.out.println(z.threeSumClosest(nums, target));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (i == 0 && j == 1 && k == 2) {
                        min = nums[i] + nums[j] + nums[k];
                    } else {
                        int sum = nums[i] + nums[j] + nums[k];
                        if (Math.abs(target - sum) < Math.abs(target - min)) {
                            min = sum;
                        }
                    }
                }
            }

        }
        return min;
    }

}
