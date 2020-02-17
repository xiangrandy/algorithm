package 数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * @author x00418543
 * @since 2020年2月12日
 */
public class IntersectionOfTwoArraysII350 {

    public static void main(String[] args) {
        IntersectionOfTwoArraysII350 i = new IntersectionOfTwoArraysII350();
        int[] nums1 = { 1, 2, 2, 1 };
        int[] nums2 = { 2, 2 };
        int[] result = i.intersect(nums1, nums2);
        System.out.println(result);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> m1 = new HashMap<>();
        for (int num : nums1) {
            m1.put(num, m1.getOrDefault(num, 0) + 1);
        }
        int k = 0;
        for (int n : nums2) {
            int cnt = m1.getOrDefault(n, 0);
            if (cnt > 0) {
                nums1[k] = n;
                k++;
                m1.put(n, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

}
