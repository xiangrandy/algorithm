package 查找;

public class 搜索插入位置35 {

    public static void main(String[] args) {
        搜索插入位置35 s = new 搜索插入位置35();
        int[] nums = { 1, 3, 5, 7, 8, 11, 13, 15, 122, 1343 };
        int target = 1444;
        System.out.println(s.searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        return binarySearch(0, nums.length - 1, target, nums);
    }

    public int binarySearch(int start, int end, int target, int[] nums) {
        if (target < nums[start]) {
            return start;
        }
        if (target > nums[end]) {
            return end + 1;
        }
        int middle = (start + end) / 2;
        if (nums[middle] < target) {
            return binarySearch(middle + 1, end, target, nums);
        } else if (nums[middle] > target) {
            return binarySearch(start, middle - 1, target, nums);
        } else {
            return middle;
        }
    }

}
