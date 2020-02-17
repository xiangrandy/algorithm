package 数组;

public class 数组中重复的数字面试题03 {

    public static void main(String[] args) {
        数组中重复的数字面试题03 s = new 数组中重复的数字面试题03();
        int[] nums = { 2, 3, 1, 0, 2, 5, 3 };
        System.out.println(s.findRepeatNumber(nums));
    }

    public int findRepeatNumber(int[] nums) {
        boolean[] r = new boolean[nums.length];
        for (int n : nums) {
            if (!r[n]) {
                r[n] = true;
            } else {
                return n;
            }
        }
        throw new IllegalArgumentException("数组中不存在重复数字！");
    }

}
