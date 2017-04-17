package yj.lintcode;

import tools.TreeNode;


// O(n) time  O(1) space
// ����ǰ�������չƽ������
public class FlattenBinaryTreetoLinkedList  {

	private TreeNode prev = null; // ��˽�г�Ա������������һ�����ʽڵ㣡������

	public void flatten(TreeNode root) {
		if (root == null)
			return;

		// �������
		TreeNode l = root.left;
		TreeNode r = root.right;
		if (prev != null) {
			prev.left = null;
			prev.right = root;
		}
		prev = root;  // ����prev��λ��
		flatten(l);
		flatten(r);
	}

}
