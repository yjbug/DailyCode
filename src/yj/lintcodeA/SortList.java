package yj.lintcodeA;

import tools.ListNode;

public class SortList {
	/**
	 * @param head:
	 *            The head of linked list.
	 * @return: You should return the head of the sorted linked list, using
	 *          constant space complexity.
	 */
	public ListNode sortList(ListNode head) {
		int len = 0;
		ListNode tmp = head;
		while (tmp != null) {
			len++;
			tmp = tmp.next;
		}
		partition(head, len);
		return head;
	}

	// 单向链表，采用一个方向调整的partition，第一个元素为轴值
	// 不把第一个元素置换到最后面,把小于轴值的元素有序的交换到左边
	// 注意，轴值为最小值时要处理，不然死循环
	public void partition(ListNode head, int len) {
		if (len <= 1) {
			return;
		}
		ListNode id = head;
		ListNode minId = head;
		int p = head.val;
		int i = 0;
		int minCount = 0;
		while (i < len) {
			if (id.val < p) {
				swap(id, minId);
				minId = minId.next;
				id = id.next;
				minCount++;
			} else {
				id = id.next;
			}
			i++;
		}
		// 一次partition结束
		if (minCount == 0) { // 如果轴值是最小值
			minId = minId.next;
			minCount = 1;
		}
		partition(head, minCount);
		partition(minId, len - minCount);
	}

	// 采用交换元素内部的value完成交换
	public void swap(ListNode x, ListNode y) {
		int tmp = x.val;
		x.val = y.val;
		y.val = tmp;
	}
}
