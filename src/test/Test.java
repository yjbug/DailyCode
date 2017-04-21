package test;

import java.util.LinkedList;
import java.util.Queue;

import tools.TreeNode;

public class Test {
	public static void main(String[] args) {
		int l = 1;
		int r = 3;
		int mid = l + ((r - l) >> 1);
		System.out.println(mid);
		String s ="love";
		System.out.println("love"+1+'c');
	}
	
	public void levelOrder(TreeNode node){
		if(node == null) {
			return;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(node);
		while(q.size()!=0){
			TreeNode cur = q.poll();
			if(cur.left!=null){
				q.add(cur.left);
			}
			if(cur.right!=null){
				q.add(cur.right);
			}
		}
	}
}
