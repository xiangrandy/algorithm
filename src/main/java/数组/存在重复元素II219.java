package 数组;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class 存在重复元素II219 {

    public static void main(String[] args) {
        存在重复元素II219 c = new 存在重复元素II219();
        int[] nums = { 1, 2, 3, 1, 2, 3 };
        int k = 3;
        System.out.println(c.containsNearbyDuplicate(nums, k));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            LinkedList<Integer> indexes = map.get(nums[i]);
            if (indexes == null) {
                indexes = new LinkedList<>();
                indexes.add(i);
                map.put(nums[i], indexes);
            } else {
                int lastIndex = indexes.getLast();
                if (i - lastIndex <= k) {
                    return true;
                }
                indexes.add(i);
            }
        }
        return false;
    }

}
