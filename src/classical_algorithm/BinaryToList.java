package classical_algorithm;

import tools.TreeNode;

public class BinaryToList {

	private TreeNode prev = null;

	public static void main(String[] args) {
		BinaryToList T = new BinaryToList();
		TreeNode root = TreeNode.getTree();
		T.binaryConvertToList(root);
		while(root.left!=null){
			root = root.left;
		}
		while(root!=null){
			System.out.println(root.val);
			root = root.right;
		}
		
		boolean is = T.isBST(TreeNode.getTreeCBT());
		System.out.println(is);
		
		
	}
	
	// ��������������ת��������˫������
	// ���ı���
	public void binaryConvertToList(TreeNode root){
		if(root==null){
			return;
		}
		
		binaryConvertToList(root.left);
		TreeNode r = root.right; 
		root.left = prev;
		if(prev!=null){
			prev.right = root;
		}
		prev = root;	//��ǰ�ڵ������ϣ�����prevΪ��ǰ�ڵ�
		binaryConvertToList(r);
	}
	
	
	
	public boolean isBST(TreeNode root){
		if(root==null){
			return true;
		}
		
		if(!isBST(root.left)){
			return false;
		}
		TreeNode r = root.right; 
		if(prev!=null){
			if(prev.val>=root.val)
				return false;
		}
		prev = root;	//��ǰ�ڵ������ϣ�����prevΪ��ǰ�ڵ�
		if(!isBST(r)){
			return false;
		}
		return true;
	}
	
	

}
