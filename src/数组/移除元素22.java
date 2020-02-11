package 数组;

public class 移除元素22 {

    public static void main(String[] args) {
        移除元素22 y = new 移除元素22();
        int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
        int val = 2;
        int length = y.removeElement(nums, val);
        System.out.println(length);
    }

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

}
