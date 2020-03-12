package 树;

public class 二叉树的直径543 {

	int diameter;

	public static void main(String[] args) {
		二叉树的直径543 e = new 二叉树的直径543();
		TreeNode root = null;
		e.diameterOfBinaryTree(root);
	}

	public int diameterOfBinaryTree(TreeNode root) {
		diameter = 1;
		depth(root);
		return diameter - 1;
	}
	public int depth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int leftDepth = depth(node.left);
		int rightDepth = depth(node.right);
		diameter = Math.max(diameter, leftDepth + rightDepth + 1);
		return Math.max(leftDepth, rightDepth) + 1;
	}

}
