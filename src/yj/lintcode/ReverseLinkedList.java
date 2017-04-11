package yj.lintcode;

import tools.ListNode;

// 递归与非递归的实现
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
			// 注意，Java参数按值传递  想要修改指针可以借用对象的成员来完成
			res.next = head;
		}
		return head;
	}
	
	public ListNode reverseR(ListNode head){
		// 新建一个res,  其next用来指向最终的头结点
		ListNode res = new ListNode(0);
		reverseRecursion(head, res);
		head.next = null;
		return res.next;
	}

}
