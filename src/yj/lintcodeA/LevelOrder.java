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
	
	// 从左往右看二叉树，只显示看到的节点
	public void printLeft(TreeNode root){
		if(root==null){
			return;
		}
		Queue<TreeNode> q = new LinkedList<>();
		// initialize
		q.add(root);
		int curSize = 1;
		int nextSize = 0;
		boolean first = true;
		while(q.size()!=0){
			if(first){
				first = false;
				System.out.println(q.peek().val);
			}
			TreeNode cur =  q.poll();
			curSize--;
			if(cur.left!=null){
				q.add(cur.left);
				nextSize++;
			}
			if(cur.right!=null){
				q.add(cur.right);
				nextSize++;
			}
			//  判断当前层是否结束
			if(curSize==0){
				first = true;
				curSize = nextSize;
				nextSize = 0;
			}	
		}
	}
	
	public static void main(String[] args) {
		LevelOrder T = new LevelOrder();
		T.printLeft(TreeNode.getTree());
	}
	

}
