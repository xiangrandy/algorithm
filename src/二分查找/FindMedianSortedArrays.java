package 二分查找;
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * 中位数
 * 
 * @author x00418543
 * @since 2020年1月11日
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        FindMedianSortedArrays f = new FindMedianSortedArrays();
        int[] nums1 = { 1, 2, 6 };
        int[] nums2 = { 3, 4, 5 };
        System.out.println(f.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if ((m + n) % 2 == 0) {
            // 如果m+n是偶数，找到第(m+n)/2和第((m+n)/2+1)个数，取两者平均值
            return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, (m + n) / 2)
                    + getKth(nums1, 0, n - 1, nums2, 0, m - 1, ((m + n) / 2 + 1))) * 0.5;
        } else {
            // 如果m+n是奇数，找到第(m+n+1)/2个数
            return getKth(nums1, 0, n - 1, nums2, 0, m - 1, (m + n + 1) / 2);
        }
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 > len2) {
            // 让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }
        if (len1 == 0) {
            // 如果nums1为空，则取nums2的第k个数，即为我们要找的数
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            // 如果k为1，则nums1[start1]、nums2[start2]中较小的数即为我们要找的数
            return Math.min(nums1[start1], nums2[start2]);
        }
        // 找到nums1和nums2的第k/2个数，如果k/2超过length，则取第length个数
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;
        // 截取数据，递归查找
        if (nums1[i] > nums2[j]) {
            // 如果nums1[i]比nums2[j]要大，则截取掉nums2[j]之前的数据
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            // 如果nums1[i]比nums2[j]要小，则截取掉nums1[i]之前的数据
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

}
