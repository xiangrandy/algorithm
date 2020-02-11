package 数组;

/**
 * 删除排序数组中的重复项
 * 
 * @author x00418543
 * @since 2020年1月15日
 */
public class 删除排序数组中的重复项 {

    public static void main(String[] args) {
        删除排序数组中的重复项 s = new 删除排序数组中的重复项();
        int[] nums = { 1, 2, 2 };
        int length = s.removeDuplicates(nums);
        System.out.println(length);
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            // 如果nums[i]不等于nums[index],则将nums[index+1]写为nums[i]，index++
            if (nums[i] != nums[index]) {
                nums[index + 1] = nums[i];
                index++;
            }
        }
        return index + 1;
    }

}
