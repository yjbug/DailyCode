package classical_algorithm;

import tools.Entry;

public class MinStack {
	// ����ⷨ���� һ��ջ + һ������ջ
	// ��������HashMap�����ݽṹ�������ͷһ��Ԫ�ر��浱ǰ��Сֵ
	// ��Ӧɢ�г�����Ԫ�ض��Ǵ��ڵ�ǰ��Сֵ��Ԫ��
	// ��ɢ��ʱ��Ԫ������ڵ�ǰ��СֵԪ�صĺ󷽶�����󷽣��������
	// ������ʱ�������������⣬��ʼ����Сcapacity = 100
	private int capacity = 100;
	// Entry ʹ�ó�Ա���� value , next
	// ��ʼ���󣬸���Ԫ��ֵΪnull
	@SuppressWarnings("unchecked")
	private Entry<Integer, Integer> entrys[] = new Entry[capacity];
	private int size = 0; // ��¼����Ԫ�ظ���
	private int minSize = -1; // ��¼�˵�ǰ��Сֵ������

	public MinStack() {
		// do initialize if necessary
	}
	
	public int size(){
		return size;
	}

	public void push(int number) {
		if (minSize == -1) {
			minSize++;
			entrys[minSize] = new Entry<Integer, Integer>();
			entrys[minSize].value = number;
		} else {
			int min = entrys[minSize].value;
			if (number >= min) {
				// ��ǰ�ڵ�ĺ�һ��Ԫ��������µ�Ԫ��
				Entry<Integer, Integer> temp = new Entry<>();
				temp.value = number;
				temp.next = entrys[minSize].next;
				entrys[minSize].next = temp;
			} else {
				// ��Ҫ������Сֵ��minSize++
				minSize++;
				// ��ʱ��������������
				if (capacity == minSize) {
					System.out.println("�ռ����þ�");
					return;
				}
				entrys[minSize] = new Entry<Integer, Integer>();
				entrys[minSize].value = number;
			}
		}
		size++;
	}

	public int pop() {
		int res;
		if (size == 0) {
			System.out.println("error");
			return -1;
		} else {
			size--;
			Entry<Integer, Integer> node = entrys[minSize];
			if (node.next != null) {
				res = node.next.value;
				node.next = node.next.next;
				return res;
			} else {
				// ���ص�ǰ��Сֵ����minSize--
				res = node.value;
				// ��ֹ�ڴ�й¶
				entrys[minSize] = null;
				minSize--;
				return res;
			}
		}
	}

	public int min() {
		return entrys[minSize].value;
	}
}
