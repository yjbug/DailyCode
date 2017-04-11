package yj.lintcode;

import tools.ListNode;

// �ݹ���ǵݹ��ʵ��
public class ReverseLinkedList {
	public ListNode reverse(ListNode head) {
		// write your code here
		ListNode pre = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}

	public ListNode reverseRecursion(ListNode head ,ListNode res){
		if(head.next!=null){
			reverseRecursion(head.next ,res).next = head;
		}else{
			// ע�⣬Java������ֵ����  ��Ҫ�޸�ָ����Խ��ö���ĳ�Ա�����
			res.next = head;
		}
		return head;
	}
	
	public ListNode reverseR(ListNode head){
		// �½�һ��res,  ��next����ָ�����յ�ͷ���
		ListNode res = new ListNode(0);
		reverseRecursion(head, res);
		head.next = null;
		return res.next;
	}

}
