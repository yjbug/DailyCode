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

	// ������������һ�����������partition����һ��Ԫ��Ϊ��ֵ
	// ���ѵ�һ��Ԫ���û��������,��С����ֵ��Ԫ������Ľ��������
	// ע�⣬��ֵΪ��СֵʱҪ������Ȼ��ѭ��
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
		// һ��partition����
		if (minCount == 0) { // �����ֵ����Сֵ
			minId = minId.next;
			minCount = 1;
		}
		partition(head, minCount);
		partition(minId, len - minCount);
	}

	// ���ý���Ԫ���ڲ���value��ɽ���
	public void swap(ListNode x, ListNode y) {
		int tmp = x.val;
		x.val = y.val;
		y.val = tmp;
	}
}
