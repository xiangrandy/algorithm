package 双指针;
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * 双指针
 * 
 * @author x00418543
 * @since 2020年1月13日
 */
public class 盛最多水的容器 {

    public static void main(String[] args) {
        盛最多水的容器 s = new 盛最多水的容器();
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(s.maxArea(height));
    }

    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxarea;
    }

}
