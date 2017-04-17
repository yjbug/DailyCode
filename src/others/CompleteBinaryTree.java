package others;

import java.util.LinkedList;
import java.util.Queue;
import tools.TreeNode;

public class CompleteBinaryTree {

	public static void main(String[] args) {
		CompleteBinaryTree T = new CompleteBinaryTree();
		boolean res = T.isCBT(TreeNode.getTree());
		System.out.println(res);
		res = T.isCBT(TreeNode.getTreeCBT());
		System.out.println(res);
		
	}

	public boolean isCBT(TreeNode root) {
		if (root == null) {
			return false;
		}
		Queue<TreeNode> q = new LinkedList<>();
		int flag = 0; // 0����ǰ�ڵ���ȫ�����ӣ�1����û�����ӣ�2����û���Һ���,3����û�к���
		q.add(root);
		while (flag == 0) {
			if (q.size() != 0) {
				TreeNode cur = q.poll();
				if (cur.left != null) {
					q.add(cur.left);
				} else {
					flag++;
				}
				if (cur.right != null) {
					q.add(cur.right);
				} else {
					flag += 2;
				}
			}
		}
		// ����ѭ�� flag is 1 �� 2 or 3
		if (flag == 1) {
			return false;
		}
		// ����������Ԫ�ض������к���
		while (q.size() != 0) {
			TreeNode cur = q.poll();
			if (cur.left != null || cur.right != null) {
				return false;
			}
		}
		return true;
	}
}
