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
		int flag = 0; // 0代表当前节点有全部孩子，1代表没有左孩子，2代表没有右孩子,3代表都没有孩子
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
		// 跳出循环 flag is 1 、 2 or 3
		if (flag == 1) {
			return false;
		}
		// 队列中所有元素都不能有孩子
		while (q.size() != 0) {
			TreeNode cur = q.poll();
			if (cur.left != null || cur.right != null) {
				return false;
			}
		}
		return true;
	}
}
