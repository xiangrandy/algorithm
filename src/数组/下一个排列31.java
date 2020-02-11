package 数组;

public class 下一个排列31 {

    public static void main(String[] args) {
        下一个排列31 x = new 下一个排列31();
        int[] nums = { 2, 2, 2, 2 };
        x.nextPermutation(nums);
        System.out.println();
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            // 寻找低位
            i--;
        }
        if (i >= 0) {
            // 寻找交换点并交换
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        // 翻转
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
