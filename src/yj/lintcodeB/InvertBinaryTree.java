package yj.lintcodeB;

import tools.TreeNode;

public class InvertBinaryTree {
	public void invertBinaryTree(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertBinaryTree(root.left);
		invertBinaryTree(root.right);
	}
}
