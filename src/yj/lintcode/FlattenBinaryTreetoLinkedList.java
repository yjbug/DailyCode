package yj.lintcode;

import tools.TreeNode;


// O(n) time  O(1) space
// 按照前序遍历，展平二叉树
public class FlattenBinaryTreetoLinkedList  {

	private TreeNode prev = null; // 用私有成员变量来缓存上一个访问节点！！！！

	public void flatten(TreeNode root) {
		if (root == null)
			return;

		// 先序遍历
		TreeNode l = root.left;
		TreeNode r = root.right;
		if (prev != null) {
			prev.left = null;
			prev.right = root;
		}
		prev = root;  // 更新prev的位置
		flatten(l);
		flatten(r);
	}

}
