package 树;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的后序遍历 {

    private List<Integer> l = new ArrayList<>();

    public static void main(String[] args) {
        二叉树的后序遍历 e = new 二叉树的后序遍历();
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
        visit(root);
        return l;
    }

    private void visit(TreeNode node) {
        if (node == null) {
            return;
        }
        // 前序遍历
        if (node.left != null) {
            visit(node.left);
        }
        // 中序遍历
        if (node.right != null) {
            visit(node.right);
        }
        // 后序遍历
        l.add(node.val);
    }

}
