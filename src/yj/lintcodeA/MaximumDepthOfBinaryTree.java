package yj.lintcodeA;

import tools.TreeNode;

public class MaximumDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		// ��������������ݹ����ظ�����
		int l = 1+maxDepth(root.left);
		int r = 1+maxDepth(root.right);
		return l>r?l:r;
	}
}
