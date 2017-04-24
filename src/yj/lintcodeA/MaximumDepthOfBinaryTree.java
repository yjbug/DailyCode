package yj.lintcodeA;

import tools.TreeNode;

public class MaximumDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		// 类似先序遍历，递归无重复访问
		int l = 1+maxDepth(root.left);
		int r = 1+maxDepth(root.right);
		return l>r?l:r;
	}
}
