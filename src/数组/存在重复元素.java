package 数组;

import java.util.HashSet;
import java.util.Set;

public class 存在重复元素 {

    public static void main(String[] args) {
        存在重复元素 c = new 存在重复元素();
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(c.containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x : nums) {
            if (set.contains(x)) {
                return true;
            }
            set.add(x);
        }
        return false;
    }

}
