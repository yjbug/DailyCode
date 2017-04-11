package classical_algorithm;

import tools.Entry;

public class MinStack {
	// 常规解法采用 一个栈 + 一个辅助栈
	// 采用类似HashMap的数据结构，数组的头一个元素保存当前最小值
	// 对应散列出来的元素都是大于当前最小值的元素
	// 且散列时，元素添加在当前最小值元素的后方而非最后方，方便查找
	// 由于暂时不考虑扩容问题，初始化大小capacity = 100
	private int capacity = 100;
	// Entry 使用成员属性 value , next
	// 初始化后，各个元素值为null
	@SuppressWarnings("unchecked")
	private Entry<Integer, Integer> entrys[] = new Entry[capacity];
	private int size = 0; // 记录所有元素个数
	private int minSize = -1; // 记录了当前最小值的索引

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
				// 当前节点的后一个元素添加上新的元素
				Entry<Integer, Integer> temp = new Entry<>();
				temp.value = number;
				temp.next = entrys[minSize].next;
				entrys[minSize].next = temp;
			} else {
				// 需要更新最小值，minSize++
				minSize++;
				// 暂时不考虑扩容问题
				if (capacity == minSize) {
					System.out.println("空间已用尽");
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
				// 返回当前最小值，且minSize--
				res = node.value;
				// 防止内存泄露
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
