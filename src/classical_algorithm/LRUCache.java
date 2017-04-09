package classical_algorithm;

import java.util.HashMap;

class Entry {
	Entry prev;// ǰһ�ڵ�
	Entry next;// ��һ�ڵ�
	Object value;// ֵ
	Object key;// ��
}

/**
 * Least recently used �㷨�������ݵ���ʷ���ʼ�¼��������̭���ݣ������˼���ǡ����������������ʹ�����ô���������ʵļ���Ҳ���ߡ���
 * ʹ��һ������ͷ��βָ���˫��������ΪLRU�������ݣ���һ��HashMap�洢����ʵ��O(1)���ң�
 * 
 * 
 * �������ʡ�
 * 
 * �������ȵ�����ʱ��LRU��Ч�ʺܺã���ż���Եġ������Ե����������ᵼ��LRU�����ʼ����½���������Ⱦ����Ƚ����ء�
 * 
 * �����Ӷȡ�
 * 
 * ʵ�ּ򵥡�
 * 
 * �����ۡ�
 * 
 * ����ʱ��Ҫ���������ҵ����е����ݿ�������Ȼ����Ҫ�������Ƶ�ͷ����
 */
public class LRUCache {
	private int cacheSize;
	private HashMap<Object, Entry> nodes;// ��������
	private int currentSize;
	private Entry first;// ����ͷ
	private Entry last;// ����β

	public LRUCache(int i) {
		currentSize = 0;
		cacheSize = i;
		nodes = new HashMap<Object, Entry>(i);// ��������
	}

	/**
	 * ��ȡ�����ж���,������������ǰ��
	 */
	public Entry get(Object key) {
		Entry node = nodes.get(key);
		if (node != null) {
			moveToHead(node);
			return node;
		} else {
			return null;
		}
	}

	/**
	 * ��� entry��HashMap, ����entry
	 */
	public void put(Object key, Object value) {
		// �Ȳ鿴HashMap�Ƿ���ڸ�entry, ������ڣ���ֻ������value
		Entry node = nodes.get(key);

		if (node == null) {
			// ���������Ƿ��Ѿ�������С.
			if (currentSize >= cacheSize) {
				// �Ƴ� HashMap �� LRUCache ���������ʹ�õ�һ��Ԫ��
				nodes.remove(last.key);
				removeLast();
			} else {
				currentSize++;
			}
			node = new Entry();
		}
		node.value = value;
		node.key = key;
		// ������ʹ�õĽڵ�ŵ�����ͷ����ʾ����ʹ�õ�.
		moveToHead(node);
		nodes.put(key, node);
	}

	/**
	 * ɾ������β���ڵ㣬��ʹ����� ʹ�õ�entry
	 */
	private void removeLast() {
		// ����β��Ϊ��,������βָ��null. ɾ������β��ɾ������ʹ�õĻ������
		if (last != null) {
			if (last.prev != null)
				last.prev.next = first;
			else
				first = null;
			last = last.prev;
		}
	}

	/**
	 * �ƶ�������ͷ����ʾ����ڵ�������ʹ�ù���
	 */
	private void moveToHead(Entry node) {
		if (node == first)
			return;
		// remove node
		if (node.prev != null)
			node.prev.next = node.next;
		if (node.next != null)
			node.next.prev = node.prev;
		// reset last
		if (last == node)
			last = node.prev;
		// remove node to first and reset first
		if (first != null) {
			node.next = first;
			first.prev = node;
		}
		first = node;
		node.prev = null;
		if (last == null)
			last = first;
	}

	/*
	 * ��ջ���
	 */
	public void clear() {
		first = null;
		last = null;
		currentSize = 0;
	}
}
