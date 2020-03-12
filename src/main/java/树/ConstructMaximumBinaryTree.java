package 树;
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * 构造最大二叉树
 * 
 * @author x00418543
 * @since 2020年1月9日
 */
public class ConstructMaximumBinaryTree {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 6, 0, 5 };
        ConstructMaximumBinaryTree tree = new ConstructMaximumBinaryTree();
        TreeNode treeNode = tree.constructMaximumBinaryTree(nums);
        System.out.println(treeNode);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int maxIndex = findMaxIndex(nums, 0, nums.length - 1);
        TreeNode node = new TreeNode(nums[maxIndex]);
        if (maxIndex == 0) {
            node.left = null;
        } else {
            int[] left = new int[maxIndex];
            System.arraycopy(nums, 0, left, 0, left.length);
            node.left = constructMaximumBinaryTree(left);
        }
        if (maxIndex == nums.length - 1) {
            node.right = null;
        } else {
            int[] right = new int[nums.length - maxIndex - 1];
            System.arraycopy(nums, maxIndex + 1, right, 0, right.length);
            node.right = constructMaximumBinaryTree(right);
        }
        return node;
    }

    public int findMaxIndex(int[] nums, int left, int right) {
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}
