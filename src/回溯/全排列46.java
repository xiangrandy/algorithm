package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 全排列46 {

    // 结果集
    List<List<Integer>> result = new LinkedList<>();

    public static void main(String[] args) {
        全排列46 q = new 全排列46();
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> res = q.permute(nums);
        System.out.println(res);
    }

    public List<List<Integer>> permute(int[] nums) {
        // 记录路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return result;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            // 满足结束条件,结果集中放入结果
            result.add(new ArrayList<>(track));
            return;
        }
        // 选择列表
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 撤销选择
            track.removeLast();
        }
    }

}
