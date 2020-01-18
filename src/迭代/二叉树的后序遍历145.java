/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

package 迭代;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import 树.TreeNode;

/**
 * 迭代算法
 * 
 * @author x00418543
 * @since 2020年1月17日
 */
public class 二叉树的后序遍历145 {

    public static void main(String[] args) {
        二叉树的后序遍历145 e = new 二叉树的后序遍历145();
        TreeNode root = new TreeNode(1);
        root.left = null;
        TreeNode node1 = new TreeNode(2);
        root.right = node1;
        TreeNode node2 = new TreeNode(3);
        node1.left = node2;
        TreeNode node3 = new TreeNode(4);
        node1.right = node3;
        List<Integer> result = e.postorderTraversal(root);
        System.out.println(result.toString());
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            output.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return output;
    }
}
