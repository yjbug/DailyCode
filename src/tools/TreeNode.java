package tools;

public class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
	
	
	//  5,4,6,3,6,5,7,3,null,2
	public static TreeNode getTree(){
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(6);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(3);
		root.left.right.left = new TreeNode(2);
		return root;
	}
	//  5,4,6,3,6,5,7,3,4,2
	public static TreeNode getTreeCBT(){
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(6);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(3);
		
		root.left.left.right = new TreeNode(4);
		
		root.left.right.left = new TreeNode(2);
		return root;
	}
	
	
	
	
}
