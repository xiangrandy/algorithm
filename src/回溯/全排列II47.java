package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 剪枝
 * 
 * @author x00418543
 * @since 2020年2月11日
 */
public class 全排列II47 {

    public static void main(String[] args) {
        全排列II47 q = new 全排列II47();
        int[] nums = { 1, 1, 3 };
        List<List<Integer>> res = q.permuteUnique(nums);
        System.out.println(res);
    }

    // 结果集
    List<List<Integer>> result = new LinkedList<>();
    boolean[] used = null;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
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
            if (used[i]) {
                // 如果节点已选择，则不再选择该节点
                continue;
            }
            // 如果节点没选择
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                // 剪枝
                continue;
            }
            // 做选择
            track.add(nums[i]);
            used[i] = true;
            // 进入下一层决策树
            backtrack(nums, track);
            // 撤销选择
            track.removeLast();
            used[i] = false;
        }
    }

}
