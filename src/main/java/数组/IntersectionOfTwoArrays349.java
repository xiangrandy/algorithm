package 数组;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Intersection of two arrays
 * 
 * @author x00418543
 * @since 2020年2月12日
 */
public class IntersectionOfTwoArrays349 {

    public static void main(String[] args) {
        IntersectionOfTwoArrays349 i = new IntersectionOfTwoArrays349();
        int[] nums1 = { 1, 2, 2, 1 };
        int[] nums2 = { 2, 2 };
        int[] intersection = i.intersection(nums1, nums2);
        System.out.println(intersection.toString());
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) {
            set1.add(n);
        }
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) {
            set2.add(n);
        }
        if (set1.size() < set2.size()) {
            return set_intersection(set1, set2);
        } else {
            return set_intersection(set2, set1);
        }
    }

    public int[] set_intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
        int[] output = new int[set1.size()];
        int idx = 0;
        for (Integer s : set1) {
            if (set2.contains(s)) {
                output[idx++] = s;
            }
        }
        return Arrays.copyOf(output, idx);
    }

}
