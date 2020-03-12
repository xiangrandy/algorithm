package 排序;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j
 * 之间的差的绝对值最大为 ķ。 桶排序解法。
 * 
 * @author x00418543
 * @since 2020年2月12日
 */
public class 存在重复元素III220 {

    public static void main(String[] args) {
        存在重复元素III220 c = new 存在重复元素III220();
        int[] nums = { 1, 2, 3, 1 };
        int k = 3;
        int t = 0;
        System.out.println(c.containsNearbyAlmostDuplicate(nums, k, t));
    }

    private long getID(long x, long w) {
        return x < 0 ? (x + 1) / w - 1 : x / w;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) {
            return false;
        }
        Map<Long, Long> d = new HashMap<>();
        long w = (long) t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            // check if bucket m is empty, each bucket may contain at most one
            // element
            if (d.containsKey(m)) {
                return true;
            }
            // check the neighbor buckets for almost duplicate
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w) {
                return true;
            }
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w) {
                return true;
            }
            // now bucket m is empty and no almost duplicate in neighbor buckets
            d.put(m, (long) nums[i]);
            if (i >= k) {
                d.remove(getID(nums[i - k], w));
            }
        }
        return false;
    }

}
