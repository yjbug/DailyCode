package yj.lintcodeA;

import java.util.LinkedList;
import java.util.Queue;

import tools.TreeNode;

public class LevelOrder {
	public void levelOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(node);
		while (q.size() != 0) {
			TreeNode cur = q.poll();	// to do
			if (cur.left != null) {
				q.add(cur.left);
			}
			if (cur.right != null) {
				q.add(cur.right);
			}
		}
	}
}
